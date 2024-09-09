#include "Individual.h"
#include "Map.h"
#include "Population.h"
#include <vector>
#include <cstdio>
#include <cstdlib>
#include <ctime>
#include <random>
#include <fstream>
#include <iostream>
#include <string>
#include <chrono>
using namespace std;
using namespace std::chrono;

void initMap(Map& map)
{
  /*
  map.states.push_back("North Carolina");
  map.states.push_back("South Carolina");
  map.states.push_back("Virginia");
  map.states.push_back("Tennessee");
  map.states.push_back("Kentucky");
  map.states.push_back("West Virginia");
  map.states.push_back("Georgia");
  map.states.push_back("Alabama");
  map.states.push_back("Mississippi");
  map.states.push_back("Florida");

  map.borders.push_back(Border(0, 1));
  map.borders.push_back(Border(0, 2));
  map.borders.push_back(Border(0, 3));
  map.borders.push_back(Border(0, 6));
  map.borders.push_back(Border(1, 6));
  map.borders.push_back(Border(2, 3));
  map.borders.push_back(Border(2, 4));
  map.borders.push_back(Border(2, 5));
  map.borders.push_back(Border(3, 4));
  map.borders.push_back(Border(3, 6));
  map.borders.push_back(Border(3, 7));
  map.borders.push_back(Border(3, 8));
  map.borders.push_back(Border(4, 5));
  map.borders.push_back(Border(6, 7));
  map.borders.push_back(Border(6, 9));
  map.borders.push_back(Border(7, 8));
  map.borders.push_back(Border(7, 9));
  */

  map.states.push_back("Maine"); // 0
  map.borders.push_back(Border(0,1));
  map.states.push_back("New Hampshire"); // 1
  map.borders.push_back(Border(1,2));
  map.borders.push_back(Border(1,3));
  map.states.push_back("Vermont"); // 2
  map.borders.push_back(Border(2,3));
  map.borders.push_back(Border(2,6));
  map.states.push_back("Massachusetts"); // 3
  map.borders.push_back(Border(3,5));
  map.borders.push_back(Border(3,4));
  map.borders.push_back(Border(3,6));
  map.states.push_back("Connecticut"); // 4
  map.borders.push_back(Border(4,5));
  map.borders.push_back(Border(4,6));
  map.states.push_back("Rhode Island"); // 5
  map.states.push_back("New York"); // 6
  map.borders.push_back(Border(6,7));
  map.borders.push_back(Border(6,8));
  map.states.push_back("Pennsylvania"); // 7
  map.borders.push_back(Border(7,8));
  map.borders.push_back(Border(7,9));
  map.borders.push_back(Border(7,10));
  map.borders.push_back(Border(7,13));
  map.borders.push_back(Border(7,14));
  map.states.push_back("New Jersey"); // 8
  map.borders.push_back(Border(8,10));
  map.states.push_back("Maryland"); // 9
  map.borders.push_back(Border(9,10));
  map.borders.push_back(Border(9,11));
  map.borders.push_back(Border(9,12));
  map.borders.push_back(Border(9,13));
  map.states.push_back("Delaware"); // 10
  map.states.push_back("Washington DC"); // 11
  map.borders.push_back(Border(11,12));
  map.states.push_back("Virginia"); // 12
  map.borders.push_back(Border(12,13));
  map.borders.push_back(Border(12,17));
  map.borders.push_back(Border(12,18));
  map.borders.push_back(Border(12,19));
  map.states.push_back("West Virginia"); // 13
  map.borders.push_back(Border(13,14));
  map.borders.push_back(Border(13,17));
  map.states.push_back("Ohio"); // 14
  map.borders.push_back(Border(14,15));
  map.borders.push_back(Border(14,16));
  map.borders.push_back(Border(14,17));
  map.states.push_back("Michigan"); // 15
  map.borders.push_back(Border(15,16));
  map.borders.push_back(Border(15,29));
  map.states.push_back("Indiana"); // 16
  map.borders.push_back(Border(16,17));
  map.borders.push_back(Border(16,28));
  map.states.push_back("Kentucky"); // 17
  map.borders.push_back(Border(17,18));
  map.borders.push_back(Border(17,27));
  map.borders.push_back(Border(17,28));
  map.states.push_back("Tennessee"); // 18
  map.borders.push_back(Border(18,19));
  map.borders.push_back(Border(18,21));
  map.borders.push_back(Border(18,23));
  map.borders.push_back(Border(18,24));
  map.borders.push_back(Border(18,26));
  map.borders.push_back(Border(18,27));
  map.states.push_back("North Carolina"); // 19
  map.borders.push_back(Border(19,20));
  map.borders.push_back(Border(19,21));
  map.states.push_back("South Carolina"); // 20
  map.borders.push_back(Border(20,21));
  map.states.push_back("Georgia"); // 21
  map.borders.push_back(Border(21,22));
  map.borders.push_back(Border(21,23));
  map.states.push_back("Florida"); // 22
  map.borders.push_back(Border(22,23));
  map.states.push_back("Alabama"); // 23
  map.borders.push_back(Border(23,24));
  map.states.push_back("Mississippi"); // 24
  map.borders.push_back(Border(24,25));
  map.borders.push_back(Border(24,26));
  map.states.push_back("Louisiana"); // 25
  map.borders.push_back(Border(25,26));
  map.borders.push_back(Border(25,37));
  map.states.push_back("Arkansas"); // 26
  map.borders.push_back(Border(26,27));
  map.borders.push_back(Border(26,36));
  map.borders.push_back(Border(26,37));
  map.states.push_back("Missouri"); // 27
  map.borders.push_back(Border(27,28));
  map.borders.push_back(Border(27,30));
  map.borders.push_back(Border(27,34));
  map.borders.push_back(Border(27,35));
  map.borders.push_back(Border(27,36));
  map.states.push_back("Illinois"); // 28
  map.borders.push_back(Border(28,29));
  map.borders.push_back(Border(28,30));
  map.states.push_back("Wisconsin"); // 29
  map.borders.push_back(Border(29,30));
  map.borders.push_back(Border(29,31));
  map.states.push_back("Iowa"); // 30
  map.borders.push_back(Border(30,31));
  map.borders.push_back(Border(30,33));
  map.borders.push_back(Border(30,34));
  map.states.push_back("Minnesota"); // 31
  map.borders.push_back(Border(31,32));
  map.borders.push_back(Border(31,33));
  map.states.push_back("North Dakota"); // 32
  map.borders.push_back(Border(32,33));
  map.borders.push_back(Border(32,41));
  map.states.push_back("South Dakota"); // 33
  map.borders.push_back(Border(33,34));
  map.borders.push_back(Border(33,40));
  map.borders.push_back(Border(33,41));
  map.states.push_back("Nebraska"); // 34
  map.borders.push_back(Border(34,35));
  map.borders.push_back(Border(34,39));
  map.borders.push_back(Border(34,40));
  map.states.push_back("Kansas"); // 35
  map.borders.push_back(Border(35,36));
  map.borders.push_back(Border(35,39));
  map.states.push_back("Oklahoma"); // 36
  map.borders.push_back(Border(36,37));
  map.borders.push_back(Border(36,38));
  map.borders.push_back(Border(36,39));
  map.states.push_back("Texas"); // 37
  map.borders.push_back(Border(37,38));
  map.states.push_back("New Mexico"); // 38
  map.borders.push_back(Border(38,39));
  map.borders.push_back(Border(38,43));
  map.borders.push_back(Border(38,44));
  map.states.push_back("Colorado"); // 39
  map.borders.push_back(Border(39,40));
  map.borders.push_back(Border(39,43));
  map.borders.push_back(Border(39,44));
  map.states.push_back("Wyoming"); // 40
  map.borders.push_back(Border(40,41));
  map.borders.push_back(Border(40,42));
  map.borders.push_back(Border(40,43));
  map.states.push_back("Montana"); // 41
  map.borders.push_back(Border(41,42));
  map.states.push_back("Idaho"); // 42
  map.borders.push_back(Border(42,43));
  map.borders.push_back(Border(42,45));
  map.borders.push_back(Border(42,46));
  map.borders.push_back(Border(42,47));
  map.states.push_back("Utah"); // 43
  map.borders.push_back(Border(43,44));
  map.borders.push_back(Border(43,45));
  map.states.push_back("Arizona"); // 44
  map.borders.push_back(Border(44,45));
  map.borders.push_back(Border(44,48));
  map.states.push_back("Nevada"); // 45
  map.borders.push_back(Border(45,46));
  map.borders.push_back(Border(45,48));
  map.states.push_back("Oregon"); // 46
  map.borders.push_back(Border(46,47));
  map.borders.push_back(Border(46,48));
  map.states.push_back("Washington"); // 47
  map.borders.push_back(Border(47,49));
  map.states.push_back("California"); // 48
  map.borders.push_back(Border(48,50));
  map.states.push_back("Alaska"); // 49
  map.states.push_back("Hawaii"); // 50

  /*
  ifstream fin;
  fin.open("us_states_51_ij.txt");
  if (fin.fail()){
    cout << "Unable to open us_states_51_ij.txt" << endl;
    exit(1);
  }
  string line; //abbreviation of the state
  vector<string> states;
  while (!fin.eof() && !fin.fail()){
    getline(fin, line);
    states.push_back(line.substr(0, 2));
  }

  fin.close();

  for (int i = 0; i < states.size(); i++){

  }
  //fin.open("us_states_51_ij.txt");

  */
}

int main(int argc, char* argv[])
{
  auto start = high_resolution_clock::now();
  Map map;
  initMap(map);
  
  srand((unsigned)time(NULL));

  const int populationSize = 1000; 
  Population population(map, populationSize);

  const int maxIterations = 500; 
  int currentIteration = 0;
  bool goalFound = false;
  Individual bestIndividual(map); // to hold the individual representing the goal, if any
  
  double bestFitness = 0;
  while(currentIteration < maxIterations && !goalFound)
  {
    Population newPopulation(map);
    newPopulation.reserve(populationSize); // just to improve efficiency
    for(int i = 0; i < populationSize; ++i)
    {
      if (bestFitness < population.at(i).getFitness()){
        bestFitness = population.at(i).getFitness();
      }
      Individual x = population.randomSelection();
      Individual y = population.randomSelection();
      Individual child = Individual::reproduce(x, y);

      random_device rd;
      mt19937 gen(rd());
      uniform_real_distribution<> distr(0.0, 1.0);

      if(distr(gen) <= 0.2) // mutation probability (between 0 and 1)
      {
        child.mutate();
      }
      if(child.isGoal())
      {
        goalFound = true;
        bestIndividual = child;
      }
      newPopulation.push_back(child);
    }
    cout << "iteration: " << currentIteration << " best fitness: " << bestFitness << endl;
    population = newPopulation;
    ++currentIteration;
  }

  if(goalFound)
  {
    printf("Found a solution after %d iterations\n", currentIteration);
    bestIndividual.print();
  }
  else
  {
    printf("Did not find a solution after %d iterations\n", currentIteration);
  }
  auto stop = high_resolution_clock::now();
  auto duration = duration_cast<seconds>(stop - start);
  cout << "runtime = " << duration.count() << " seconds" << endl;
}