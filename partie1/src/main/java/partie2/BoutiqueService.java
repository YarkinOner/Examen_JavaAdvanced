package partie2;

import java.util.*;
import java.util.stream.*;

public class BoutiqueService {

    private final List<Produit> produits;

    public BoutiqueService(List<Produit> produits) {
        this.produits = produits;
    }

    public List<Produit> getProduitsDisponibles() {
        return produits.stream()
                .filter(p -> p.stock() > 0)
                .sorted(Comparator.comparingDouble(Produit::prix))
                .collect(Collectors.toList());
    }

    public double getPrixMoyen(String categorie) {
        return produits.stream()
                .filter(p -> p.categorie().equals(categorie))
                .mapToDouble(Produit::prix)
                .average()
                .orElse(0.0);
    }

    public Map<String, List<String>> getNomsParCategorie() {
        return produits.stream()
                .collect(Collectors.groupingBy(
                        Produit::categorie,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .map(Produit::nom)
                                        .sorted()
                                        .collect(Collectors.toList())
                        )
                ));
    }

    public Map<String, Long> getAlertesRupture(int seuil) {
        return produits.stream()
                .filter(p -> p.stock() < seuil)
                .collect(Collectors.groupingBy(
                        Produit::categorie,
                        Collectors.counting()
                ));
    }

    public Optional<Produit> getProduitLePlusCher() {
        return produits.stream()
                .max(Comparator.comparingDouble(Produit::prix));
    }

    public double getValeurTotaleStock() {
        return produits.stream()
                .mapToDouble(p -> p.prix() * p.stock())
                .sum();
    }
}