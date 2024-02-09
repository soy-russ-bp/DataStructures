# [Circular array Queue error [duplicate]](https://stackoverflow.com/questions/19758685/circular-array-queue-error)

In this scenario, the user "user2877014" attempted to implement a circular array queue using a regular Java array. The issue they encountered stemmed from their attempt to implement it with a generic type, which Java does not support.

## Root Cause

In Java, when you create a generic array, where E is a generic type that will be determined at runtime. However, arrays in Java need to know the type of their elements at compile time to allocate memory properly. But due to type erasure in Java, the information about the type E is lost at runtime. Therefore, when the code is executed, new E[capacity] doesn't know what type of object to instantiate in the array.

## Solution

To avoid this problem, it's advisable to use classes provided by the Java Collections Framework, such as ArrayList, instead of arrays when working with generic types. By using ArrayList, the generic type E is preserved at runtime, as the type of the list is determined at compile time and is not affected by type erasure. This ensures that there are no errors related to the loss of type information at runtime. Therefore, it's a common practice to prefer collection classes over arrays when working with generic types in Java.

We provide a code solution in the Code section.

## Conclusion

The utilization of arrays in certain structures can be justified for various reasons, such as complexity or memory management considerations. However, the incorporation of generic types proves highly advantageous in many projects, chiefly due to the versatility it offers to your codebase. Consequently, when leveraging generic types, it is advisable to employ ArrayLists.

