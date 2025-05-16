n = int(input())
pattern = input()
prefix, suffix = pattern.split('*')

for _ in range(n):
    word = input()
    if len(word) >= len(prefix) + len(suffix) and word.startswith(prefix) and word.endswith(suffix):
        print("DA")
    else:
        print("NE")
