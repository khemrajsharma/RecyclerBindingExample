package com.ks.recyclerbindingexample.data;

import android.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by KHEMRAJ on 10/23/2018.
 */
public class NameGenerator {
    public static String[] parents = new String[]{
            "Keneth Vandeusen",
            "Dodie Corea",
            "Dagmar Pines",
            "Tula Horwitz",
            "Lorinda Salzer",
            "Madge Brumett",
            "Brain Urquhart",
            "Ema Sciacca",
            "Tiffiny Pipkins",
            "Ellyn Cross",
            "Era Camillo",
            "Davida Younts",
            "Taneka Araya",
            "Irwin Davison",
            "Johnie Wellman",
            "Guadalupe Crothers",
            "Quiana Grahm",
            "Melina Schepis",
            "Bruce Restivo",
            "Rebecca Loach",
    };
    public static String[] children = new String[]{
            "Melvin Schrader",
            "Hoa Walden",
            "Rene Bolin",
            "Jay Lande",
            "Kala Ottesen",
            "Shawnda Mogensen",
            "Mauricio Pough",
            "Lyndsey Santistevan",
            "Audria Baskerville",
            "Louanne Anding",
            "Gail Vosburg",
            "Mira Haug",
            "Patience Lloyd",
            "Eddy Giberson",
            "Fawn Hild",
            "Jacque Claypool",
            "Dorene Maple",
            "Refugio Worth",
            "Hortense Darst",
            "Gustavo Lininger",
    };

    public static Pair<String, List<String>> getDummyParentChildrenPair() {
        int randomParent = new Random().nextInt(parents.length);
        List<String> childrenList = Arrays.asList(children);
        Collections.shuffle(childrenList);
        return new Pair<>(parents[randomParent], childrenList.subList(0, 5));
    }

    public static List<String> getDummyParentList() {
        return Arrays.asList(parents);
    }

    public static List<String> getDummyChildrenList() {
        return Arrays.asList(children);
    }
}
