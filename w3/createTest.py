import sys
import secrets

def create_file(n: int, filename: str = "a.inp") -> None:
    if not (0 <= n <= 255):
        raise ValueError("N must be between 0 and 255 (fits in one byte).")
    rnd = secrets.token_bytes(n)
    with open(filename, "wb") as f:
        f.write(bytes([n]))   # first byte = N
        f.write(rnd)          # next N random bytes

def main() -> None:
    if len(sys.argv) >= 2:
        try:
            n = int(sys.argv[1])
        except ValueError:
            print("Usage: createTest.py N (0-255)")
            sys.exit(1)
    else:
        n = int(input("N (0-255): ").strip())
    create_file(n)
    print(f"Created 'a.inp' with {n+1} bytes (first byte = {n}).")

if __name__ == "__main__":
    main()