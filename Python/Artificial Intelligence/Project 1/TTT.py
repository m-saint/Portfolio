import sys
import math
import random


def check_winner(board, player_id, opponent_id):
    for symbol in ['blue', 'orange']: # check for win/loss conditions (horizontal, vertical, diagonal)
        for row in board:
            if all(cell == symbol for cell in row):
                return 1 if symbol == player_id else -1
        for col in range(3):
            if all(board[row][col] == symbol for row in range(3)):
                return 1 if symbol == player_id else -1
        if all(board[i][i] == symbol for i in range(3)) or all(board[i][2 - i] == symbol for i in range(3)):
            return 1 if symbol == player_id else -1
    if all(board[row][col] != " " for row in range(3) for col in range(3)):
        return 0 # draw
    return None # still going


def minimax(board, depth, alpha, beta, maximizing, player_id, opponent_id): # minimax algorithm implementation with ab pruning
    winner = check_winner(board, player_id, opponent_id)
    if winner is not None:
        return winner

    if maximizing:
        max_eval = -math.inf
        for row in range(3):
            for col in range(3):
                if board[row][col] == " ":
                    board[row][col] = player_id
                    eval = minimax(board, depth + 1, alpha, beta, False, player_id, opponent_id)
                    board[row][col] = " "
                    max_eval = max(max_eval, eval)
                    alpha = max(alpha, eval)
                    if beta <= alpha:
                        return max_eval
        return max_eval
    else:
        min_eval = math.inf
        for row in range(3):
            for col in range(3):
                if board[row][col] == " ":
                    board[row][col] = opponent_id
                    eval = minimax(board, depth + 1, alpha, beta, True, player_id, opponent_id)
                    board[row][col] = " "
                    min_eval = min(min_eval, eval)
                    beta = min(beta, eval)
                    if beta <= alpha:
                        return min_eval
        return min_eval


def find_best_move(board, player_id, opponent_id):
    best_move = (0,0)
    best_value = -math.inf

    for row in range(3):
        for col in range(3):
            if board[row][col] == " ":
                board[row][col] = player_id
                move_value = minimax(board, 0, -math.inf, math.inf, False, player_id, opponent_id)
                board[row][col] = " "
                if move_value >= best_value:
                    if move_value == best_value: # random tie-breaker
                        if random.choice([True, False]):
                            best_move = (row, col)
                    else:
                        best_value = move_value
                        best_move = (row, col)

    return best_move


def interpret_move(input): # take input from user and convert it into usable row and column
    col = input[0]
    row = input[1]

    if col == "a":
        col = 0
    elif col == "b":
        col = 1
    else:
        col = 2

    if row == "1":
        row = 2
    elif row == "2":
        row = 1
    else:
        row = 0

    return row, col

def make_move(board, player_id, opponent_id): # given a tic-tac-toe configuration, decide the best move and convert it to human-friendly format
    row, col = find_best_move(board, player_id, opponent_id)
    if row == 0:
        if col == 0:
            move = "a3"
        elif col == 1:
            move = "b3"
        else:
            move = "c3"
    elif row == 1:
        if col == 0:
            move = "a2"
        elif col == 1:
            move = "b2"
        else:
            move = "c2"
    else:
        if col == 0:
            move = "a1"
        elif col == 1:
            move = "b1"
        else:
            move = "c1"

    board[row][col] = player_id # keep track of your own move
    return move


def main():

    # initialize game, including board and player colors

    board = [
        [" ", " ", " "],
        [" ", " ", " "],
        [" ", " ", " "]
    ]

    valid_moves = [
        "a3", "b3", "c3",
        "a2", "b2", "c2",
        "a1", "b1", "c1"
    ]

    player_id = input().strip()

    if player_id == "blue":
        opponent_id = "orange"
        move = make_move(board, player_id, opponent_id) # blue gets to go first
        print(move, flush=True)
    else: opponent_id = "blue"

    while True: # run through the game by taking input from user, marking the opponent's move, and responding
        try:

            game_input = input().strip()
            if game_input not in valid_moves:
                print("invalid: that's not a space")
                sys.exit(0)
            row, col = interpret_move(game_input)
            if board[row][col] != ' ':
                print("invalid: that space is already occupied")
                sys.exit(0)
            board[row][col] = opponent_id

            move = make_move(board, player_id, opponent_id)
            winner = check_winner(board, player_id, opponent_id)
            print(move, flush=True)
            if winner == 1:
                print(player_id, "has won!")
                sys.exit(0)
            elif winner == -1:
                print(opponent_id, "has won!")
                sys.exit(0)
            elif winner == 0:
                print("it's a draw!")
                sys.exit(0)


        except EOFError:
            break
if __name__ == "__main__":
    main()