# **Using-Simulated-Annealing-to-Break-a-Playfair-Cipher**

## **The Playfair Cipher**
The Playfair Cipher is a symmetric polygram substitution cipher invented by the Victorian
scientist Sir Charles Wheatstone in 1854 (of Wheatstone Bridge fame). The cipher is named
after his colleague Lord Playfair, who popularised and promoted the encryption system. Due to
its simplicity, the Playfair Cipher was used at a tactical level by both the British and US forces
during WWII and is also notable for its role in the rescue of the crew of PT-109 in the Pacific
in 1943.
Polygram substitution is a classical system of encryption in which a group of n plain-text letters
is replaced as a unit by n cipher-text letters. In the simplest case, where n = 2, the system is
called digraphic and each letter pair is replaced by a cipher digraph. The Playfair Cipher uses
digraphs to encrypt and decrypt from a 5x5 matrix constructed from a sequence key of 25
unique letters. Note that the letter J is not included.

## **The Simulated Annealing Algorithm**
Simulated annealing (SA) is an excellent approach for breaking a cipher using a randomly
generated key. Unlike conventional Hill Climbing algorithms, that are easily side-tracked by
local optima, SA uses randomization to avoid heuristic plateaux and attempt to find a global
maxima solution. The following pseudocode shows how simulated annealing can be used break
a Playfair Cipher. Note that the initial value of the variables temp and transitions can have a
major impact on the success of the SA algorithm.

![image](https://user-images.githubusercontent.com/14197773/38440561-be012492-39d9-11e8-8ce9-921cee5f1052.png)

The generation of a random 25-letter key on line 1 only requires that we shuffle a 25 letter
alphabet. A simple algorithm for achieving this was published in 1938 by Fisher and Yates.
The Fisher–Yates Shuffle generates a random permutation of a finite sequence, i.e. it randomly
shuffles an array key of n elements (indices 0..n-1) as follows:

![image](https://user-images.githubusercontent.com/14197773/38440627-ec5144ee-39d9-11e8-9363-1e014348bd15.png)


