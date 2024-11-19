def arbolNavidad(altura: int) -> str:
  for i in range(1, altura + 1):
    print(' ' * (altura - i) + '*' * (2 * i - 1))
  else:
    print(" " *(altura//2+1)+ "***")


print(arbolNavidad(3))