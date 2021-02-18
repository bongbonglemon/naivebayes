<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Thanks again! Now go create something AMAZING! :D
***
***
***
*** To avoid retyping too much info. Do a search and replace for the following:
*** github_username, repo_name, twitter_handle, email, project_title, project_description
-->

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->

<!-- PROJECT LOGO -->
<br />
<p align="center">

  <h3 align="center">Naive Bayes Classifier</h3>

  <p align="center">
    My Java implementation of the Naive Bayes Classifier to classify Stack Exchange questions

<!--
    <br />
    <a href="https://github.com/github_username/repo_name"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/github_username/repo_name">View Demo</a>
    ·
    <a href="https://github.com/github_username/repo_name/issues">Report Bug</a>
    ·
    <a href="https://github.com/github_username/repo_name/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li><a href="#prerequisites">Prerequisites</a></li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#extension">Extension</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
    <li>
      <a href="#useful-links">Useful links</a>
    </li>
  </ol>
</details>


<!-- ABOUT THE PROJECT -->
## About The Project

My first entry into machine learning was a HackerRank challenge. I was tasked to classify a list of Stack Exchange questions into their correct topics. I was disappointed that the responses from other hackers simply imported libraries to solve the challenge and made up my point to implement the Naive Bayes Classifer from scratch. Although I had read that Python was the programming language of choice for machine learning the only language I knew at that point of time was Java. I thought that the same task might have been tougher to code in Java but I took it as a challenge and carried on.

Here is the pseudocode from the book I referred to, titled "Machine Learning" by Tom Mitchell. I did not however implement the steps to calculate P(v). I used a uniform distribution instead.

![pseudo code](https://github.com/gordon-lim/NaiveBayesClassifier/blob/master/Screen%20Shot%202019-02-20%20at%209.26.14%20PM.png)

<!-- PREREQUISITES -->
## Prerequisites

The JSON library for Java is the only dependency. It can be downloaded <a href="https://mvnrepository.com/artifact/org.json/json/20140107">here</a>. (Download the .jar file)

<!-- USAGE EXAMPLES -->
## Usage

Upon running the program, the algorithm jumps right into learning from the labelled training data. Once the learning is completed, a brief introduction to the program is printed to the terminal.

```
learning...
Hi! This program uses Naive Bayes algorithm to predict the topic of an input question
The possible topics are:
gis
security
photo
mathematica
unix
wordpress
scifi
electronics
android
apple
```

The user is then prompted to choose between testing the algorithm with his/her own question. Or testing against a list of questions provided by HackerRank.

```
Press 1 to use testcases
Press 0 to provide own question
```

### Try it yourself!

Enter 0 to provide your own question and type the following: "How to fix my iPhone?" As you would expect, the algorithm correctly predicts 'apple'!

<!-- EXTENSION -->
## Extension

You may test the accuracy of my model by comparing the topic predictions of the questions testcase/input.txt against the groundtruth labels in testcase/output.txt

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.

<!-- CONTACT -->
## Contact

Gordon - gordonlim214@gmail.com

<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements

* "Machine Learning" by Tom Mitchell.

<!-- USEFUL LINKS -->
## Useful Links

* [Luis Serrano's friendly approach to Naive Bayes classifer](https://www.youtube.com/watch?v=Q8l0Vip5YUw)

