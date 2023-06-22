# CPT212 Assignment 1 - Radix Sort

This repository contains the code for implementing the radix sort algorithm for integers and floating-point numbers, as well as determining the time complexity of each implementation.

## Integer Radix Sort
The `IntegerRadix.java` file contains the code for the integer radix sort implementation. This algorithm sorts a list of integers using the radix sort technique, which sorts the numbers digit by digit, starting from the least significant digit to the most significant digit.

<br> 
## Floating-Point Radix Sort
The `FloatingRadix.java` file contains the code for the floating-point radix sort implementation. This algorithm extends the integer radix sort to handle floating-point numbers by treating them as integers. It performs the radix sort on the integer representations of the floating-point numbers.

<br>
## Time Complexity
The time complexity of the integer radix sort is O(kn), where n is the number of elements in the input list and k is the maximum number of digits in the largest integer. This complexity arises because the algorithm iterates through each digit of each element in the list.
The `CounterIntegerRadix.java` contains the code to calculate the number of primitive operation which is used to determine its time complexity

<br>
The time complexity of the floating-point radix sort is also O(kn), as the algorithm treats floating-point numbers as integers and performs the radix sort on their integer representations. Thus, the number of digits and iterations remain the same.
The `CounterFloatingrRadix.java` contains the code to calculate the number of primitive operation which is used to determine its time complexity
