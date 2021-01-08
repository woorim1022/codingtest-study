//이진 트리 (비선형 자료구조)
//포인터를 사용해야함 (특정 루트에서 자식노드에 접근할 수 있음)
//완전 이진 트리가 아니면 배열로 표현하기 어렵다(데이터 낭비)
//전위 순회 : 자기자신, 왼쪽, 오른쪽 순으로 방문 1 2 4 8 9 5 10 11 3 6 12 13 7 14 15
//후위 순회 : 왼쪽, 오른쪽, 자기자신 순으로 방문 8 9 4 10 11 5 2 12 13 6 14 15 7 3 1
//중위 순회 : 왼쪽, 자기자신, 오른쪽 순으로 방문 8 4 9 2 10 5 11 1 12 6 13 3 14 7 15
#include <iostream>
using namespace std;

int number = 15;
 
//하나의 노드 정보를 선언합니다.
typedef struct node *treePointer;

typedef struct node {
    int data;
    treePointer leftChild, rightChild;
} node;

//전위 순회를 구현합니다.
void preorder(treePointer ptr){
    if(ptr){
        cout << ptr->data << ' ';
        preorder(ptr->leftChild);
        preorder(ptr->rightChild);
    }
}

//후위 순회를 구현합니다.
void postorder(treePointer ptr){
    if(ptr){
        postorder(ptr->leftChild);
        postorder(ptr->rightChild);
        cout << ptr->data << ' ';
    }
}

//중위 순회를 구현합니다.
void inorder(treePointer ptr){
    if(ptr){
        inorder(ptr->leftChild);
        cout << ptr->data << ' ';
        inorder(ptr->rightChild);
    }
}

int main(void){
    node nodes[number + 1];
    for(int i = 1; i <= number; i++){
        nodes[i].data = i;
        nodes[i].leftChild = NULL;
        nodes[i].rightChild = NULL;
    }
    for(int i = 1; i <= number; i++){
        if(i % 2 == 0)
            nodes[i / 2].leftChild = &nodes[i];
        else 
            nodes[i / 2].rightChild = &nodes[i];
        
    }
    postorder(&nodes[1]);
    return 0; 
}


 
