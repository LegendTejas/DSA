# 🧮 Arrays & Hashing

This section covers problems and concepts related to **Arrays and Hashing**, which are the foundation of Data Structures & Algorithms (DSA). Mastering these will help you build efficient solutions for real-world problems and ace technical interviews.

---

## 📌 What You’ll Learn
- Basics of Arrays (declaration, traversal, operations)
- Hashing concepts (HashMap, HashSet, frequency maps)
- Common interview problems and patterns
- Optimized approaches using hashing for faster lookups
- Trade-offs between arrays and hashing techniques

---

## 🔑 Key Operations

### Arrays
- Access elements by index in **O(1)**
- Insert and delete operations
- Iteration and traversal
- Sorting and searching

### Hashing
- Store key-value pairs with **HashMap**
- Ensure uniqueness with **HashSet**
- Frequency counting
- Handling collisions (conceptual)

---

## 🚀 Example Problems

1. **Two Sum** – Find indices of two numbers that add up to a target.  
2. **Contains Duplicate** – Check if an array contains duplicates.  
3. **Valid Anagram** – Verify if two strings are anagrams.  
4. **Group Anagrams** – Group words that are anagrams.  
5. **Top K Frequent Elements** – Find the most frequent elements in an array.  

Each problem demonstrates how arrays and hashing can be applied for **time-efficient solutions**.

---

## 📝 Pseudocode Example – Two Sum

```text
function twoSum(nums, target):
    create a hashmap

    for i in range(0, length of nums):
        complement = target - nums[i]
        if complement exists in hashmap:
            return [i, hashmap[complement]]
        else:
            store nums[i] with index i in hashmap
```
