//���� Ʈ�� (���� �ڷᱸ��)
//�����͸� ����ؾ��� (Ư�� ��Ʈ���� �ڽĳ�忡 ������ �� ����)
//���� ���� Ʈ���� �ƴϸ� �迭�� ǥ���ϱ� ��ƴ�(������ ����)
//���� ��ȸ : �ڱ��ڽ�, ����, ������ ������ �湮 1 2 4 8 9 5 10 11 3 6 12 13 7 14 15
//���� ��ȸ : ����, ������, �ڱ��ڽ� ������ �湮 8 9 4 10 11 5 2 12 13 6 14 15 7 3 1
//���� ��ȸ : ����, �ڱ��ڽ�, ������ ������ �湮 8 4 9 2 10 5 11 1 12 6 13 3 14 7 15
#include <iostream>
using namespace std;

int number = 15;
 
//�ϳ��� ��� ������ �����մϴ�.
typedef struct node *treePointer;

typedef struct node {
    int data;
    treePointer leftChild, rightChild;
} node;

//���� ��ȸ�� �����մϴ�.
void preorder(treePointer ptr){
    if(ptr){
        cout << ptr->data << ' ';
        preorder(ptr->leftChild);
        preorder(ptr->rightChild);
    }
}

//���� ��ȸ�� �����մϴ�.
void postorder(treePointer ptr){
    if(ptr){
        postorder(ptr->leftChild);
        postorder(ptr->rightChild);
        cout << ptr->data << ' ';
    }
}

//���� ��ȸ�� �����մϴ�.
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


 
