# Friends Pairing Problem
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given N&nbsp;friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.<br>
Note: Since answer can be very large, return your answer&nbsp;mod 10^9+7.</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>N = 3
<strong>Output:</strong> 4
<strong>Explanation</strong>:
{1}, {2}, {3} : All single
{1}, {2,3} : 2 and 3 paired but 1 is single.
{1,2}, {3} : 1 and 2 are paired but 3 is single.
{1,3}, {2} : 1 and 3 are paired but 2 is single.
Note that {1,2} and {2,1} are considered same.</span>
</pre>

<p><span style="font-size:18px"><strong>Example 2:&nbsp;</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>: N = 2
<strong>Output:</strong> 2
<strong>Explanation</strong>:
{1} , {2} : All single.
{1,2} : 1 and 2 are paired.
</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>countFriendsPairings()&nbsp;</strong>which accepts an integer n&nbsp;and return&nbsp;number of ways in which friends can remain single or can be paired up.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(N)<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(1)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N&nbsp;≤ 10<sup>4</sup></span></p>
 <p></p>
            </div>