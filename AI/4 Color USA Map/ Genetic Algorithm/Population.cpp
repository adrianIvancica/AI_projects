#include "Population.h"
#include <random>
#include <iostream>


Population::Population(const Map& map, int initialSize) : map(&map)
{
  for(int i = 0; i < initialSize; ++i)
  {
    push_back(Individual(map));
  }
}

Population& Population::operator=(const Population& other)
{
  assign(other.begin(), other.end());
  map = other.map;
  return *this;
}

Individual& Population::randomSelection()
{
  std::random_device rd;
  std::mt19937 gen(rd());
  double sum_of_weights = 0;
  for (long unsigned int i = 0; i < size(); i++){
    sum_of_weights += at(i).getFitness();
  }
  std::uniform_real_distribution<> distr(0.0, sum_of_weights);
  double rnd = distr(gen);
  for (long unsigned int i = 0; i < size(); i++){
    if(rnd < at(i).getFitness()){
      return at(i);
    }
    rnd -= at(i).getFitness();
  }
  std::cout << "Error randomSelection(), returning front()" << std::endl;
  return front();
}