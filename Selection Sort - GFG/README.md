# Selection Sort
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given an unsorted array of size N, use selection sort to sort arr[] in increasing order.</span></p>

<p><br>
<strong><span style="font-size:18px">Example 1:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 5
arr[] = {4, 1, 3, 9, 7}</span>
<span style="font-size:18px"><strong>Output:</strong>
1 3 4 7 9</span>
<span style="font-size:18px"><strong>Explanation:</strong>
Maintain sorted (in bold) and unsorted subarrays.
Select 1. Array becomes <strong>1</strong> 4 3 9 7.
Select 3. Array becomes <strong>1 3</strong> 4 9 7.
Select 4. Array becomes <strong>1 3 4</strong> 9 7.
Select 7. Array becomes <strong>1 3 4 7</strong> 9.
Select 9. Array becomes <strong>1 3 4 7 9</strong>.</span></pre>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N = 10
arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}</span>
<span style="font-size:18px"><strong>Output:</strong>
1 2 3 4 5 6 7 8 9 10</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task: &nbsp;</strong><br>
You dont need to read input or print anything. Complete the functions&nbsp;<strong>select() and selectionSort()</strong>&nbsp;,where select() takes arr[] and starting point of unsorted array i as input parameters and returns the selected element for each iteration in selection sort, and selectionSort() takes the array and it's size and sorts the array.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity: </strong>O(N<sup>2</sup>)<br>
<strong>Expected Auxiliary Space: </strong>O(1)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10^3</span></p>
 <p></p>
            </div>