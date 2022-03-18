# Card Matching Game
**Name of Team:** Null Coders

**Project Title:** Card Matching Game

| First and Last Name | Email              | Lecture & Lab Section |
| ------------------- | ------------------ | --------------------- |
| Anthony Dang        | dang23@my.yorku.ca | Section P Lab 02      |
| Raman Clair         | ramanc@my.yorku.ca | Section P Lab 02      |
| Tenzin Dekhang      | tenzd@my.yorku.ca  | Section P Lab 02      |



**Project Description:** 

The game will consist of a board where a number of playing cards will be placed. The number of cards will vary based on the difficulty chosen at the start of the game. The user will be prompted to enter a username and then the game will begin. All of the cards will start facing down, and the player gets to pick two cards to flip in each turn. If the cards are a pair, they remain facing up, otherwise they are flipped back. The objective is to find and flip all of the pairs of matching cards in the shortest number of turns. After all cards are flipped, the user’s score is calculated based on the number of turns taken and difficulty level. After calculating the score, the username submitted by the user would be posted on the leaderboard. The user will then be prompted to either try again, change the difficulty, or view the leaderboard.



**Functional Requirements:**

- Intro Screen
  - Name of the project and creators
  - Button to advance to next screen
  - Button to show the leaderboard 
- Username Input
  - Box to enter user's name 
    - A name must be input 
- Difficulty Selection
  - 3 buttons for 3 corresponding difficulty levels
    - Easy (4x4, total 16 cards)
    - Medium (6x5, 30 total cards)
    - Hard (8x6, 48 total cards)
- Game Board
  - The game is created based on the difficulty selected 
  - Cards are shuffled and rendered onto the appropriate game board 
  - Clicking on a card will flip it over, revealing its contents
  - When two cards are flipped, they will be checked if they are matching. Matching card will be taken out of the board while non-matching cards will be flipped back face down
- End Screen
  - When all the cards are matched and the board is empty, the end screen will appear
  - Score is calculated based on the difficulty and the number of turns taken
  - 3 buttons for playing again, viewing the leaderboard, or returning to the menu
- Other Requirements
  - Card images / assets 
  - Aesthetic UI 
  - Math behind calculating the user's score 
  - Sound effect for slipping the matching cards (maybe)
  - Simple animations for flipping and matching cards (maybe)

 
