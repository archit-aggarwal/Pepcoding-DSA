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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */

// Leetcode 336
struct TrieNode
{
    TrieNode *children[26];
    vector<int> pos; // To store palindromic positions in str
    int id;
    bool isLeaf;
    TrieNode()
    {
        isLeaf = false;
        for (int i = 0; i < 26; i++)
            children[i] = NULL;
    }
};
 
bool isPalindrome(string str, int i, int len)
{
    while (i < len)
    {
        if (str[i] != str[len])
            return false;
        i++, len--;
    }
    return true;
}
 
void insert(TrieNode* root, string key, int id)
{
    TrieNode *temp = root;
 
    for (int level = key.length()-1; level >=0; level--)
    {
        int index = (int)(key[level] - 'a');
        
        if (!temp->children[index])
            temp->children[index] = new TrieNode;
        
        if (isPalindrome(key, 0, level))
            (temp->pos).push_back(id);
        
        temp = temp->children[index];
    }
    temp->id = id;
    temp->pos.push_back(id);
    temp->isLeaf = true;
}
 
void search(TrieNode *root, string key,
            int id, vector<vector<int>> &result)
{
    TrieNode *temp = root;
    for (int level = 0; level < key.length(); level++)
    {
        int index = (int)(key[level] - 'a');
 
        if (temp->id >= 0 && temp->id != id &&
            isPalindrome(key, level, key.size()-1))
            
        result.push_back({id, temp->id});
 
        if (!temp->children[index]) return;
 
        temp = temp->children[index];
    }
 
    for (int i: temp->pos)
    {
        if (i == id) continue;
        result.push_back({id, i});
    }
}
class Solution {
public:
    vector<vector<int>> palindromePairs(vector<string>& vect) {
        TrieNode *root = new TrieNode;
        for (int i = 0; i < vect.size(); i++)
            insert(root, vect[i], i);

        vector<vector<int> > result;
        for (int i=0; i<vect.size(); i++)
            search(root, vect[i], i, result);
        return result;
    }
};

// Leetcode 1032
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
class StreamChecker {
public:
    Node* root;
    int Longest_word = 0;
    string curr = "";
    void insert(Node* temp, string s) 
    {
        for(int i=s.size()-1;i >= 0;i--)
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
    
    bool search(Node* temp, string s) 
    {
        for(int i=s.size()-1;i >= 0;i--)
        {
            if(temp->terminal == true)
                return true;
            if(temp->children.find(s[i]) == temp->children.end())
                return false;    
            temp = temp->children[s[i]];
        }
        return temp->terminal;
    }
    
    StreamChecker(vector<string>& words) {
        root =  new Node('\0'); 
        Longest_word = 0;
        for(auto i: words)
        {
            if(i.size() >= 1)
            {
                insert(root, i);
                if(i.size() > Longest_word)
                    Longest_word = i.size();
            }
        }
        curr = "";
    }
    
    bool query(char letter) {
        curr = curr + letter;
        if(curr.size() > Longest_word)
            curr = curr.substr(1);
        return search(root, curr);
    }
};

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker* obj = new StreamChecker(words);
 * bool param_1 = obj->query(letter);
 */
