# Maximum Path Sum between 2 Leaf Nodes
##  Hard 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a binary tree in which each node element contains a number. Find the maximum possible path sum from one leaf node to another leaf node.</span></p>

<p><span style="font-size:18px"><strong>Note: </strong>Here&nbsp;Leaf node is a node which is connected to exactly one different node.</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:      </strong>
           3                               
         /    \                          
       4       5                     
      /  \      
    -10   4                          </span>
<span style="font-size:18px"><strong>Output:</strong> 16</span>
<span style="font-size:18px"><strong>Explanation:</strong>
Maximum Sum lies between leaf node 4 and 5.
4 + 4 + 3 + 5 = 16.</span>
</pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:    </strong>
            -15                               
         /      \                          
        5         6                      
      /  \       / \
    -8    1     3   9
   /  \              \
  2   -3              0
                     / \
                    4  -1
                       /
                     10  </span>
<span style="font-size:18px"><strong>Output:</strong>  27</span>
<span style="font-size:18px"><strong>Explanation:</strong>
The maximum possible sum from one leaf node 
to another is (3 + 6 + 9 + 0 + -1 + 10 = 27)</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task: &nbsp;</strong><br>
You dont need to read input or print anything. Complete the function <strong>maxPathSum() </strong>which takes root node as input parameter and returns the maximum sum between 2 leaf nodes.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N)<br>
<strong>Expected Auxiliary Space:</strong> O(Height of Tree)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong></span><br>
<span style="font-size:18px">2&nbsp; ≤&nbsp; Number of nodes&nbsp; ≤&nbsp; 10<sup>4</sup></span><br>
<span style="font-size:18px">-10<sup>3&nbsp;&nbsp;</sup>≤ Value of each node&nbsp;≤ 10<sup>3</sup></span></p>
 <p></p>
            </div>