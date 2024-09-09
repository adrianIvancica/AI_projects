README

use "/cpp" as your working directory

compile using the following command:
g++ -Wall -o maps Individual.cpp Population.cpp main.cpp

execute the project with:
./maps


NOTE:
configuration: *THIS IS CHANGEABLE IN THE CODE*
    populationSize = 1000;
    maxIterations = 500;
    mutation probability = 0.2
With this configuration the algorithm takes about 500 seconds to calculate a solution and finds a goal about 75% of the time within 500 iterations
Its recommended to run this program multiple times in parallel to increase the speed of a solution being found