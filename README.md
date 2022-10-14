# K-Ary Heap
Implementation of a k-ary heap that allows arbitrary branching factors. Supports a generic object for the item stored in the heap and an object that implements 
comparable interface for the priority key.
Currently supports the following operations:
- top():      Removes the top element of the heap and returns it to the user.
- peek():     Finds the top element of the heap and returns it to the user. Same as top() except it doesn't remove the it.
- insert(Object o, Priority p):   Adds an element to the heap according to some ordering which can be defined on a generic object
- update(Object oldObject, Priority newP): Updates the priority of an object that is equivalent to oldObject (based on .equals()).
