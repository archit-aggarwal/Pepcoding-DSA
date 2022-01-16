#include <vector>

using namespace std;

struct Node{
    vector<Node*> child;
    bool leaf;
    
    Node(){
        for(int i = 0; i < 26; i++){
            child.push_back(NULL);
        }
        leaf = false;
    }
};

void insert(Node* &head, string s){
    Node* curr = head;
    
    for(int i = 0; i < s.size(); i++){
        if(curr->child[s[i]-'a'] == NULL){
            curr->child[s[i]-'a'] = new Node();
        }    
        curr = curr->child[s[i]-'a'];
    }
    
    curr->leaf = true;
}

string sub(string s, int n){
    string ans = "";
    
    for(int i = 0; i <= n; i++){
        ans += s[i];
    }
    
    return ans;
}

void printAll(Node* head, string s, int& count){
    if(!head){
        return;
    }
    else if(head->leaf){
        count++;
        cout << s << " ";
    }
    
    for(int i = 0; i < 26; i++){
        printAll(head->child[i], s+(char)('a'+i), count);
    }
}

void print(Node* head, string s, int& count){
    Node* curr = head;
    
    for(int i = 0; i < s.size(); i++){
        if(curr->child[s[i]-'a'] == NULL){
            return;
        }
        curr = curr->child[s[i]-'a'];
    }
    
    printAll(curr, s, count);
}

int main()
 {
	//code
	int test;
	cin >> test;
	
	while(test--){
	    int n;
	    cin >> n;
	    
	    vector<string> names(n);
	    Node* root = new Node();
	    
	    for(int i = 0; i < n; i++){
	        cin >> names[i];
	        insert(root, names[i]);
	    }
	    
	    string s;
	    cin >> s;
	    
	    for(int i = 0; i < s.size(); i++){
	        string q = sub(s, i);
	        int count = 0;
	        
	        print(root, q, count);
	        
	        if(count == 0){
	            cout << "0";
	        }
	        cout << endl;
	    }
	}
	
	return 0;
}