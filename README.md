# **Using-Simulated-Annealing-to-Break-a-Playfair-Cipher**

### *Artificial Intelligence - Lecturer: Dr John Healy - 4th Year (Hons) Software Development, GMIT*

## **How to run:**
1. Open command prompt. 
2. Navigate to location of the playfair.jar file.
3. Enter the following command on the command line: `java –cp ./playfair.jar ie.gmit.sw.ai.CipherBreaker`
4. Menu should appear. Enter 1.
5. Enter the name of textfile eg. cyphertext-2018.txt.
6. Enter 2. Enter name of output file eg. helloworld.txt
7. Enter 3.

Aplication runs and returns text file to current directory.

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

The method shuffleKey() on line 6 should make the following changes to the key with the
frequency given (you can approximate this using Math.random() * 100):
* Swap single letters (90%)
* Swap random rows (2%)
* Swap columns (2%)
* Flip all rows (2%)
* Flip all columns (2%)
* Reverse the whole key (2%)

## **Using n-Gram Statistics as a Heuristic Function**
An n-gram (gram = word or letter) is a substring of a word(s) of length n and can be used to
measure how similar some decrypted text is to English. For example, the quadgrams (4-grams)
of the word “HAPPYDAYS” are “HAPP”, “APPY”, “PPYD”, “PYDA”, “YDAY” and
“DAYS”. A fitness measure or heuristic score can be computed from the frequency of
occurrence of a 4-gram, q, as follows: P(q) = count(q) / n, where n is the total number of 4-
grams from a large sample source. An overall probability of the phrase “HAPPYDAYS” can
be accomplished by multiplying the probability of each of its 4-grams:
```
P(HAPPYDAYS) = P(HAPP) × P(APPY) × P(PPYD) × P(PYDA) × P(YDAY)
```
One side effect of multiplying probabilities with very small floating point values is that
underflow can occur1 if the exponent becomes too low to be represented. For example, a Java
float is a 32-bit IEEE 754 type with a 1-bit sign, an 8-bit exponent and a 23-bit mantissa. The
64-bit IEEE 754 double has a 1-bit sign, a 11-bit exponent and a 52-bit mantissa. A simple way
of avoiding this is to get the log (usually base 10) of the probability and use the identity log(a
× b) = log(a) + log(b). Thus, the score, h(n), for “HAPPYDAYS” can be computed as a log
probability:

```
log10(P(HAPPYDAYS)) = log10(P(HAPP)) + log10(P(APPY)) + log10(P(PPYD)) +
log10(P(PYDA)) + log10(P(YDAY)
```

The resource quadgrams.txt is a text file containing a total of 389,373 4-grams, from a
maximum possible number of 264
=456,976. The 4-grams and the count of their occurrence
were computed by sampling a set of text documents containing an aggregate total of
4,224,127,912 4-grams. The top 10 4-grams and their occurrence is tabulated below:

| q         | Count(q)      | 4-gram,q  |Count(q)|
| --------- |:-------------:|:-----:    |------:|
| TION      | 13168375      | FTHE      |8100836|
| NTHE      | 11234972      | THES      |7717675|
| THER      | 10218035      | WITH      |7627991|
| THAT      | 8980536       | INTH      |7261789|
| THER      | 10218035      | ATIO      |7104943|

The 4-grams of “HAPPYDAYS”, their count, probability and log value are tabulated below.

| q         | Count(q)      | 4-gram,q      |Count(q)|
| --------  |:------------: |:-----:        |-----------:|
| APP       | 462336        | 0.000109451   |-3.960779349|
| APPY      | 116946        | 0.000027685   |-4.557751689|
| PPYD      | 4580          | 0.000001084   |-5.964871583|
| PYDA      | 1439          | 0.000000340   |-6.467676267|
| YDAY      | 108338        | 0.000025647   |-4.590956247|
| DAYS      | 635317        | 0.000150401   |-3.822746584|

The final score, h(n), for “HAPPYDAYS” is just the sum of the log probabilities, i.e. -
3.960779349 + -4.557751689 + -5.964871583 + -6.467676267 + -4.590956247 + -
3.822746584 = -29.36478172. A decrypted message with a larger score than this is more “English” than this text and therefore must have been decrypted with a “better” key.