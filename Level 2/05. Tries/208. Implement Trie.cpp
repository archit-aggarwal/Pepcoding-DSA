class Node
{
    public:
    char data;
    unordered_map<char,Node*> children;
    bool terminal;
    Node(char data)
    {
        this->data = data;
        terminal = false;
    }
};
class Trie {
public:
    Node* root;
    Trie() { root = new Node('\0'); }
    
    void insert(string s) 
    {
        Node* temp = root;
        for(int i=0;i < s.size();i++)
        {
            if(temp->children.find(s[i]) != temp->children.end())
                temp = temp->children[s[i]];
            else 
            {
                Node* newNode = new Node(s[i]);
                temp->children[s[i]] = newNode;
                temp = newNode;
            }
        }
        temp->terminal = true;
    }
    
    bool search(string s) 
    {
        Node* temp = root;
        for(int i=0;i < s.size();i++)
        {
            if(temp->children.find(s[i]) == temp->children.end())
                return false;    
            temp = temp->children[s[i]];
        }
        return temp->terminal;
    }
    
    bool startsWith(string s) 
    {
        Node* temp = root;
        for(int i=0;i<s.size();i++)
        {
            if(temp->children.find(s[i]) == temp->children.end())
                return false;    
            temp = temp->children[s[i]];
        }
        return true;
    }
};
