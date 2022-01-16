 {
	int T;
	cin>>T;
	while(T--)
	 {
	    string str;
	    cin>>str;
	    vector<int> Hash(26,false);
	    int Max = 0,curr = 0;
	    int left = 0,right = 0,res = INT_MAX;
	    for(int i=0;str[i]!='\0';i++)
	    {
	        if(Hash[str[i]-97]==0)
	        {
	            Hash[str[i]-97]=1;
	            Max++;
	        }
	    }
	    for(int i=0;i<26;i++) Hash[i] = 0;
	    while(right < str.length())
	    {
	        if(Hash[str[right]-97]==0)
	         curr++;
	        Hash[str[right]-97]++;
	        if(curr == Max)
	        {
	            while(Hash[str[left]-97]>1)
	            {
	             Hash[str[left]-97]--;
	             left++;
	            }
	            if(right-left+1 < res) res = right-left+1;
	        }
	        right++;
	    }
	    cout<<res<<endl;
	 }
	 return 0;
}