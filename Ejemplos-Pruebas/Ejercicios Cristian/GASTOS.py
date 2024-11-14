# ‘Martha’s spending was low for {x} months, medium for {y} months and high for {z} months.’
 
monthly_spending = [2689.56, 2770.38, 2394.04, 2099.91, 3182.20, 3267.12, 1746.83, 2545.72, 3328.20, 3147.30, 2462.61, 3890.45, 3000.00, 2000.00]

def spending(monthly_spending: list) -> str:
    low = 0
    medium = 0
    high = 0
    for spending in monthly_spending:
        if spending < 2500:
            low += 1
        elif spending < 3000:
            medium += 1
        else:
            high += 1
    return f"Martha’s spending was low for {low} months, medium for {medium} months and high for {high} months."

print(spending(monthly_spending)) 

# Martha is interested in knowing her average expenses for each half of the year. Compute her average
#  expenses for the first half of the year (January to June) and for the second half of the year (July to December). 
# Display the information as follows:

def average_spending(monthly_spending: list) -> str:
    first_half = monthly_spending[:6]
    second_half = monthly_spending[6:]
    return f"Martha’s average spending for the first half of the year was {sum(first_half) / len(first_half)} and for the second half of the year was {sum(second_half) / len(second_half)}."

print(average_spending(monthly_spending))

# Martha wants to know the months in which she spent the most and the least. Compute the month with the 
# highest and lowest expenses and display the information as follows:

def most_least_spending(monthly_spending: list) -> str:
    most = max(monthly_spending)
    least = min(monthly_spending)
    return f"Martha spent the most in month {monthly_spending.index(most) + 1} and the least in month {monthly_spending.index(least) + 1}."

print(most_least_spending(monthly_spending))

# Martha wants to know the months in which she spent more than the average and less than the average.
#  Compute the months in which she spent more than the average and the months in which she spent less than the average and 
# display the information as follows:

def more_less_average(monthly_spending: list) -> str:
    average = sum(monthly_spending) / len(monthly_spending)
    more = [month + 1 for month, spending in enumerate(monthly_spending) if spending > average]
    less = [month + 1 for month, spending in enumerate(monthly_spending) if spending < average]
    return f"Martha spent more than the average in months {more} and less than the average in months {less}."

# Sin comprehensions.

def more_less_average_v2(monthly_spending: list) -> str:
    average = sum(monthly_spending) / len(monthly_spending)
    more = []
    less = []
    for month, spending in enumerate(monthly_spending):
        if spending > average:
            more.append(month + 1)
        elif spending < average:
            less.append(month + 1)
    return f"Martha spent more than the average in months {more} and less than the average in months {less}."

# Martha’s expenses are currently expressed in USD. Create a new list named monthly_spending_eur that contains the 
# same expenditures converted into euros. Use the exchange rate of 1 USD = 0.88 EUR. Round the EUR value to two decimal 
# places using round(value, 2). Then, print monthly_spending_eur list.

monthly_spending_eur = [round(spending * 0.88, 2) for spending in monthly_spending]
print(monthly_spending_eur)

# Whitout comprehensions.

monthly_spending_eur = []
for spending in monthly_spending:
    monthly_spending_eur.append(round(spending * 0.88, 2))
print(monthly_spending_eur)

# In 2017, Martha had two credit cards: one that she used during the whole year, and another that she only used for the 
# first six months. Below you have the monthly spending values from both cards. Your task is to create a new list containing total
#  monthly spending for the entirety of 2017. Round the sums to integers and print the list.

spending_card1 = [3231.22, 3039.49, 2813.55, 2271.80, 1922.53, 2335.07]
spending_card2 = [3883.04, 3073.93, 3727.18, 2340.49, 1651.91, 1585.41, 2025.84, 3367.66, 2442.75, 2395.70, 3328.55, 3453.42]

total_spending = [round(sum(spending), 0) for spending in zip(spending_card1, spending_card2)]

# Whitout comprehensions.

total_spending = []
for spending in zip(spending_card1, spending_card2):
    total_spending.append(round(sum(spending), 0))
print(total_spending)

# Without zip.

total_spending = []
for i in range(len(spending_card1)):
    total_spending.append(round(spending_card1[i] + spending_card2[i], 0))
print(total_spending)

# Another solution.

total_spending = []

if len(spending_card1) > len(spending_card2):
    longer_len = len(spending_card1)
else:
    longer_len = len(spending_card2)
for i in range(longer_len):
    if i < len(spending_card1) and i < len(spending_card2):
        total_spending.append(round(spending_card1[i] + spending_card2[i], 0))
    elif i < len(spending_card1):
        total_spending.append(round(spending_card1[i], 0))
    else:
        total_spending.append(round(spending_card2[i], 0))
        
print(total_spending)

# Another solution.

total_spending = []
 
if len(spending_card1) > len(spending_card2):
    longer_len = len(spending_card1)
else:
    longer_len = len(spending_card2)
for i in range(longer_len):
    monthly_total = 0
    if i < len(spending_card1):
      monthly_total += spending_card1[i]
    if i < len(spending_card2):
      monthly_total += spending_card2[i]
    total_spending.append(round(monthly_total))
print(total_spending)

# Ejercicio parecido al anterior.

# Martha wants to know the total spending for each month in 2017. Compute the total spending for each month and
#  display the information as follows:

