class Node
{
    public:
    char data;
    unordered_map<char,Node*> children;
    int terminal;
    Node(char data)
    {
        this->data = data;
        terminal = -1;
    }
};
class WordFilter {
public:
    Node* root;
    void insert(string s, int id) 
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
        temp->terminal = id;
    }
    int DFS(Node* temp)
    {
        if(temp != NULL)
        {
            int Max = temp->terminal;
            for(auto i: temp->children)
            {
                int curr = DFS(i.second);
                if(curr > Max)
                    Max = curr;
            }
            return Max;
        }
        return -1;
    }
    int search(string s) 
    {
        Node* temp = root;
        for(int i=0;i < s.size();i++)
        {
            if(temp->children.find(s[i]) == temp->children.end())
                return -1;    
            temp = temp->children[s[i]];
        }
        return DFS(temp);
    }
    WordFilter(vector<string>& words) {
        root = new Node('\0');
        for(int i=0;i<words.size();i++)
        {
            string s = "#" + words[i];
            for(int j=1;j<=s.size();j++)
                insert(s.substr(j) + s, i);
        }
    }
    
    int f(string prefix, string suffix) {
        return search(suffix + "#" + prefix);
    }
};
