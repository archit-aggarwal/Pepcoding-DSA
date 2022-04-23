# Minimum steps to minimize n as per given condition
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a number <strong>N</strong>, the task is to count minimum steps to minimize it to 1 according to the following criteria:</span></p>

<ul>
	<li><span style="font-size:18px">If N is divisible by 2 then you may reduce N to N/2.</span></li>
	<li><span style="font-size:18px">If N is divisible by 3 then you may reduce N to N/3.</span></li>
	<li><span style="font-size:18px">Otherwise, Decrement N by 1.</span></li>
</ul>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>: N = 10
<strong>Output:</strong> 3
<strong>Explanation</strong>: 10 - 1 = 9 / 3 = 3 / 3 = 1</span>
</pre>

<div><span style="font-size:18px"><strong>Example 2:</strong></span></div>

<pre><span style="font-size:18px"><strong>Input: </strong>N = 1
<strong>Output: </strong>0
<strong>Explanation</strong>: N is 1</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Complete the function <strong><code>minSteps</code>()&nbsp;</strong>which takes <strong>N</strong> as input parameters and returns the integer value<br>
<br>
<strong>Expected Time Complexity:</strong> O(<strong>N</strong>)<br>
<strong>Expected Auxiliary Space:</strong> O(<strong>N</strong>)<br>
<br>
<strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>4</sup></span></p>
 <p></p>
            </div>