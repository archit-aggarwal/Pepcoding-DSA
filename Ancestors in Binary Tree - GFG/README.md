# Ancestors in Binary Tree
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a Binary Tree and a target key, you need to find all the ancestors of the&nbsp;given target key.</span></p>

<pre><span style="font-size:18px">              1
            /   \
          2      3
        /  \
      4     5
     /
    7
Key: 7
Ancestor: 4 2 1</span></pre>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
&nbsp;       </strong>1
&nbsp;     /   \
&nbsp;    2     3
target = 2<strong>
Output: </strong>1
</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
&nbsp;        1
&nbsp;      /   \
&nbsp;     2     3
&nbsp;   /  \   /  \
&nbsp;  4    5 6    8
&nbsp; /
&nbsp;7<strong>
</strong>target = 7<strong>
Output: </strong>4 2 1
</span></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
Your task is to complete the&nbsp;function <strong>Ancestors()</strong> that finds all the ancestors of the key in the given binary tree.<br>
<strong>Note:</strong><br>
The return type is<br>
<strong>cpp:&nbsp;</strong>vector<br>
<strong>Java:&nbsp;</strong>ArrayList<br>
<strong>python: </strong>list</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(N).<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(H).<br>
<strong>Note:&nbsp;</strong>H is the height of the tree and this space is used implicitly&nbsp;for the recursion stack.</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>3</sup><br>
1 ≤ data of node ≤ 10<sup>4</sup></span></p>
 <p></p>
            </div>