#ifndef SEARCH_H
#define SEARCH_H
#include <limits>

class Search
{
  public:
    Search() {}
    virtual ~Search() {}
    virtual std::vector<Vector2d>* search(Environment* env) = 0;
    virtual std::string getName() = 0;
};

class GreedySearch : public Search
{
  public:
    std::string getName() { return "greedy"; }

    std::vector<Vector2d>* search(Environment* env)
    {
      std::vector<Vector2d>* path = new std::vector<Vector2d>();
      //
      // TODO
      //
      return path;
    }
};

class UniformCostSearch : public Search
{
  public:
    std::string getName() { return "uniformcost"; }

    std::vector<Vector2d>* search(Environment* env)
    {
      std::vector<Vector2d>* path = new std::vector<Vector2d>();
      //
      // TODO
      //
      return path;
    }
};

class node 
{
  public:
  Vector2d* cord; // coordinates
  node* pre; // predecessor
  bool visited;
  double f, g, h;

  node() {
    cord = NULL;
    pre = NULL;
    visited = false;
    f = std::numeric_limits<double>::infinity();
    g = std::numeric_limits<double>::infinity();
    h = std::numeric_limits<double>::infinity();
  }
  node(Vector2d * v)
  {
    cord = v;
    pre = NULL;
    visited = false;
    if (v->x == 0 && v->y == 0) {
      f = 0;
      g = 0;
    }
    else {
      f = std::numeric_limits<double>::infinity();
      g = std::numeric_limits<double>::infinity();
    }
    h = std::numeric_limits<double>::infinity();
  }
};

class AStarSearch : public Search
{
  public:
    std::string getName() { return "astar"; }

    std::vector<Vector2d>* search(Environment* env)
    {
      std::vector<Vector2d>* path = new std::vector<Vector2d>();
      
      std::vector<node*> graph;
      std::vector<node*> Q;

      Vector2d* start = new Vector2d(0,0);
      Vector2d* goal = new Vector2d(env->width, env->height);
      graph.push_back(new node(start));
      graph.push_back(new node(goal));

      //create a wrapper called node around every polygon vertex in the environment and store them in a vector called graph
      for (int i = 0; i < env->obstacles.size(); i++){ 
        for (int j = 0; j < env->obstacles[i]->n; j++)
        {
          graph.push_back(new node(&env->obstacles[i]->v[j]));
        }
      }

      //insert starting vertex into the queue
      for (int i = 0; i < graph.size(); i++){ 
        if (graph[i]->f == 0){
          Q.push_back(graph[i]);
          break;
        }
      }
     
     // A* search algorithm (similar to dijkstra's algorithm)
      node* max = new node;
      while (!Q.empty()){ 
        node* smallestFval = max; 
        int Q_pos = -1;
        for (int i = 0; i < Q.size(); i++){ // find the node with the smallest f(n) value
          if (Q[i]->f < smallestFval->f){
            smallestFval = Q[i];
            Q_pos = i;
          }
        }
        if (smallestFval == max){ //if every node in the Q has the same max value then take the first from the queue
          smallestFval = Q[0];
        }
        smallestFval->visited = true; //set node with smallest f(n) value as visited
        Q.erase(Q.begin() + Q_pos); //remove visited node from queue
       
        //beginning of successor function
        std::vector<node*> fringe; 
        for (int i = 0; i < env->obstacles.size(); i++){ // for every polygon in the environment
          for (int j = 0; j < env->obstacles[i]->n; j++){ // check every vertex 
            bool collision = false;
            for (int k = 0; k < env->obstacles.size(); k++){ 
              //check if there is a collision with any other polygon in the environment with the line formed
              //from currently selected vertex (env->obstacles[i]->v[j]) to current node (*smallestFval->cord) 
              if(env->obstacles[k]->checkCollision(env->obstacles[i]->v[j], *smallestFval->cord)){ 
                collision = true;
                break;
              }
            }
            if (!collision){ // add vertex to fringe if there are no collisions
              for (int l = 0; l < graph.size(); l++){
                if (graph[l]->cord == &env->obstacles[i]->v[j]){
                  fringe.push_back(graph[l]);
                  break;
                } 
              }
            }
          }
        }

        bool goalReached = true;
        //do a final check to see if the current node can reach the goal node since previous search only checks the polygon vertices
        for (int i = 0; i < env->obstacles.size(); i++){ 
          if(env->obstacles[i]->checkCollision(*goal, *smallestFval->cord)){
            goalReached = false;
            break;
          }
        }
        if (goalReached){
          fringe.push_back(graph[1]);
        }
        //end of successor function

        //f(n) = g(n) + h(n)
        //g(n) = path cost to current node from start
        //h(n) = straight line distance from current node to goal
        //calculate f(n), g(n), and h(n) values as well as the predecessor node for each node in the fringe
        for (int i = 0; i < fringe.size(); i++){ 
          //distance from current node to vertex in the fringe
          double dist = sqrt(pow((fringe[i]->cord->x - smallestFval->cord->x),2) + pow(fringe[i]->cord->y - smallestFval->cord->y,2));
          //straight line distance from vertex in the fringe to the goal 
          double SLD = sqrt(pow((goal->x - fringe[i]->cord->x),2) + pow(goal->y - fringe[i]->cord->y,2));
          //adjust values of current vertex if there exists a shorter path to that vertex
          if (fringe[i]->g > smallestFval->g + dist){
            fringe[i]->g = smallestFval->g + dist;
            fringe[i]->h = SLD;
            fringe[i]->pre = smallestFval;
          }
          fringe[i]->f = fringe[i]->g + fringe[i]->h;

          bool in_Q = false;
          for (int j = 0; j < Q.size(); j++){ //checks if current vertex in fringe is already in the queue
            if (fringe[i] == Q[j]){
              in_Q = true;
              break;
            }
          }
          if(!fringe[i]->visited && !in_Q){ //only adds a new vertex to the queue
            Q.push_back(fringe[i]);
          }
        }
      }
      
      //writing to path vector
      std::vector<node*> temp;
      node* index = graph[1];
      while (index != NULL){
        temp.push_back(index);
        index = index->pre;
      }
      for (int i = temp.size()-1; i >= 0; i--){
        path->push_back(*temp[i]->cord);
      }

     return path;
    }
};

#endif
