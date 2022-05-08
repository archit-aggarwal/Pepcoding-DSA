# Rod Cutting
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a rod of length <strong>N</strong> inches and an array of prices,&nbsp;<strong>price[]</strong> that contains prices of all pieces of size smaller than <strong>N</strong>. Determine the maximum value obtainable by cutting up the rod and selling the pieces.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
<strong>Output:</strong>
22</span>
<strong><span style="font-size:18px">Explanation:
</span></strong><span style="font-size:18px">The maximum obtainable value is 22 by
cutting in two pieces of lengths 2 and 
6, i.e., 5+17=22.</span>
</pre>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N=8
Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
<strong>Output:</strong> 24
<strong>Explanation: </strong>
The maximum obtainable value is 
24 by cutting the rod into 8 pieces 
of length 1, i.e, 8*3=24. </span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>cutRod()</strong>&nbsp;which takes the array <strong>A[]</strong> and its size <strong>N</strong><strong> </strong>as inputs and returns the maximum price obtainable.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N<sup>2</sup>)<br>
<strong>Expected Auxiliary Space:</strong> O(N)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 1000<br>
1 ≤ A<sub>i</sub> ≤ 10<sup>5</sup></span></p>
 <p></p>
            </div>