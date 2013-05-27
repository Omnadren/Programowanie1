#include "Node.h"

using namespace std;

Node::Node(int nKey) {
  key = nKey;
	parent = left = right = NULL;
}


Node::~Node(void)
{
}
