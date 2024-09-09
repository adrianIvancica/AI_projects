#include "Individual.h"
#include <iostream>
#include <array>
#include <random>

using namespace std;

Individual::Individual(const Map& map) : map(&map)
{
  random_device rd;
  mt19937 gen(rd());
  uniform_int_distribution<> distr(0, 3);
  for (int i = 0; i <(end(genome)-begin(genome)); i++){
    genome[i] = distr(gen);
  }
  updateFitness();
}

Individual Individual::reproduce(const Individual& x, const Individual& y)
{
  Individual child(*x.map);

  random_device rd;
  mt19937 gen(rd());
  uniform_int_distribution<> distr(0, end(x.genome)-begin(x.genome)-1);

  //randomly slelcts a position to swap the genome
  int selection = distr(gen);
  for (int i = 0; i < end(x.genome)-begin(x.genome); i++){
    if (i < selection) { //all values to the left of the selection are take from parent x
      child.genome[i] = x.genome[i];
    }
    else { //all other values are take from parent y
      child.genome[i] = y.genome[i];
    }
  }

  child.updateFitness();
  return child;
}

bool Individual::isGoal() const
{
  if (fitness == 1.0){
    return true;
  }
  return false;
}

double Individual::getFitness() const
{
  return fitness;
}

void Individual::updateFitness()
{
  //fitness value is calculated by adding up all of the errors (same colored borders) and dividing it by the total number of borders
  
  double sameColorBorder = 0;
  for (int i = 0; i < (end(genome)-begin(genome)); i++){
    for (long unsigned int j = 0; j < map->borders.size(); j++){
      if((map->borders.at(j).index1 == i && genome[map->borders.at(j).index2] == genome[i]) || 
          (map->borders.at(j).index2 == i && genome[map->borders.at(j).index1] == genome[i])){ 
        sameColorBorder++;
      }
    }
  }
  fitness = 1 - (sameColorBorder / map->borders.size());
}

void Individual::mutate()
{
  random_device rdColor, rdState;
  mt19937 genColor(rdColor()), genState(rdState());
  uniform_int_distribution<> rndColor(0, 3), rndState(0, end(genome)-begin(genome)-1);

  genome[rndState(genState)] = rndColor(genColor);

  updateFitness();
}

void Individual::print() const
{
  cout << "fitness: " << fitness << endl;
  for (long unsigned int i = 0; i < map->states.size(); i++){
    cout << map->states.at(i) << ": " << genome[i] << endl;
  }
}