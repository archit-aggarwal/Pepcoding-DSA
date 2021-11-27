#include<bits/stdc++.h>
using namespace std;

void permute(string &input, vector<bool> &vis, string output, string &s){
	if(output.size() == s.size()){
		if(output < s){
			cout << output << endl;
		}
		return;
	}
	for(int i=0; i<input.size(); i++){
		if(vis[i] == false){
			vis[i] = true;
			permute(input, vis, output + input[i], s);
			vis[i] = false;
		}
	}
}

int main() {
	string s; cin>>s;
	vector<bool> vis(s.size(), false);
	string input = s;
	sort(input.begin(), input.end());

	permute(input, vis, "", s);
	return 0;
}
