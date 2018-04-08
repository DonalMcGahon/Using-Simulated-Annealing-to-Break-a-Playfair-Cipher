Github Link to Project - https://github.com/DonalMcGahon/Using-Simulated-Annealing-to-Break-a-Playfair-Cipher

How to run application:
1. Open command prompt. 
2. Navigate to location of the playfair.jar file.
3. Enter the following command on the command line: java –cp ./playfair.jar ie.gmit.sw.ai.CipherBreaker
4. Menu should appear. Enter 1.
5. Enter the name of textfile eg. cyphertext-2018.txt.
6. Enter 2. Enter name of output file eg. helloworld.txt.
7. Enter 3.
Application runs and returns text file to current directory.

Main Features:
-> The program takes a text document as input and discards any extra information at the start and finds the ciphered text.
-> It removes all the extra characters from the ciphered text.
-> The initial temperature for SA is dependent upon the text length.
-> It generates child keys by shuffling, flipping and reversing characters, rows and columns.
-> The probability that a wrong child is accepted shifts according to the current temperature.
-> It uses arrays to translate letters from matrix in O(1) time.
-> The Quadgram generation, Fitness calculation, and Decryption process each takes O(n) time.
-> It displays each better key and its score in output, and writes the deciphered text at the end in the output file.