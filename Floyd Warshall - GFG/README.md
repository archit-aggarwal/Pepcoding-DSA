# Floyd Warshall
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph. The Graph is represented as adjancency matrix, and the matrix denotes the weight of the edegs (if it exists) else -1. <strong>Do it in-place.</strong></span><br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>matrix = {{0,25},{-1,0}}
<strong>Output: </strong>{{0,25},{-1,0}}
<strong>Explanation: </strong>The shortest distance between
every pair is already given(if it exists).</span>
</pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>matrix = {{0,1,43},{1,0,6},{-1,-1,0}}
<strong>Output: </strong>{{0,1,7},{1,0,6},{-1,-1,0}}
<strong>Explanation: </strong>We can reach 3 from 1 as 1-&gt;2-&gt;3
and the cost will be 1+6=7 which is less than 
43.</span>
</pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read, return or print anything. Your task is to complete the function&nbsp;<strong>shortest_distance()&nbsp;</strong>which takes the matrix as input parameter and modify the distances for every pair in-place.</span><br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(n<sup>3</sup>)<br>
<strong>Expected Space Compelxity:&nbsp;</strong>O(1)</span><br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= n &lt;= 100</span></p>
 <p></p>
            </div>