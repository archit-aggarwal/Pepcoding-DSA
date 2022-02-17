# K distance from root
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a Binary Tree of size <strong>N</strong> and an integer&nbsp;<strong>K</strong>. Print all nodes that are at distance k from root (root is considered at distance 0 from itself). Nodes should be printed from left to right. If k is more that height of tree, nothing should be printed.</span></p>

<p><span style="font-size:18px">For example, if below is given tree and k is 2. Output should be 4 5 6.</span></p>

<p><span style="font-size:18px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; /&nbsp;&nbsp;&nbsp;&nbsp; \<br>
&nbsp;&nbsp;&nbsp;&nbsp; 2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3<br>
&nbsp;&nbsp; /&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; /&nbsp;&nbsp; \<br>
&nbsp; 4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5&nbsp;&nbsp;&nbsp; 6&nbsp;<br>
&nbsp;&nbsp;&nbsp;&nbsp; \<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 8</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>K = 0
&nbsp;     1
&nbsp;   /   \
&nbsp;  3     2<strong>
Output: </strong>1<strong>
</strong></span>
</pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>K = 3
&nbsp;       3
&nbsp;      /
&nbsp;     2
&nbsp;      \
&nbsp;       1
&nbsp;     /  \
&nbsp;    5    3<strong>
Output: </strong>5 3</span></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't have to take input. Complete the function&nbsp;<strong>Kdistance()&nbsp;</strong>that accepts&nbsp;<strong>root</strong> node<strong>&nbsp;</strong>and&nbsp;<strong>k&nbsp;</strong>as parameter and&nbsp;<strong>return&nbsp;</strong>the&nbsp;<strong>value&nbsp;</strong>of the&nbsp;<strong>nodes&nbsp;</strong>that are at a distance k from the root. (The values are returned as vector in&nbsp;<strong>cpp,&nbsp;</strong>as ArrayList in&nbsp;<strong>java&nbsp;</strong>and list in python)</span><br>
<span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(N).<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(Height of the Tree).</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N &lt;= 10<sup>4</sup></span><br>
<span style="font-size:18px">0 &lt;= K &lt;= 30</span><br>
<br>
<span style="font-size:14px"><strong>Note:</strong>&nbsp;The&nbsp;<strong>Input/Ouput</strong>&nbsp;format and&nbsp;<strong>Example </strong>is given&nbsp;are used for the system's internal purpose, and should be used by a user for&nbsp;<strong>Expected Output</strong>&nbsp;only. As it is a function problem, hence a user should not read any input from the stdin/console. The task is to complete the function specified, and not to write the full code.</span></p>
 <p></p>
            </div>