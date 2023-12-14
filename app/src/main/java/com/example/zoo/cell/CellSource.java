package com.example.zoo.cell;

import com.example.zoo.animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class CellSource {
    public static List<Cell> getCells(){
        List<Cell> cells = new ArrayList<>();

        List<Animal> carnivores = new ArrayList<>();
        carnivores.add(new Animal("jaguar1", "Carnivore", "jaguar"));
        carnivores.add(new Animal("jaguar2", "Carnivore", "jaguar"));
        carnivores.add(new Animal("jaguar3", "Carnivore", "jaguar"));
        carnivores.add(new Animal("jaguar4", "Carnivore", "jaguar"));

        List<Animal> herbivores = new ArrayList<>();
        herbivores.add(new Animal("sheep1", "Herbivore", "greek"));
        herbivores.add(new Animal("sheep2", "Herbivore", "greek"));
        herbivores.add(new Animal("sheep3", "Herbivore", "greek"));
        herbivores.add(new Animal("sheep4", "Herbivore", "greek"));

        Cell cell1 = new Cell("cell1", "savanna", "Carnivore");
        cell1.setAnimals(carnivores);

        Cell cell2 = new Cell("cell2", "meadow", "Herbivore");
        cell2.setAnimals(herbivores);

        cells.add(cell1);
        cells.add(cell2);

        return cells;
    }
}
