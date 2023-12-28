import matplotlib.pyplot as plt

# Read the output from the Hadoop job (assumes tab-separated values)
with open('D:\Hadoop_Project\output.txt', 'r') as file:
    lines = file.readlines()

# Extract URLs and counts
urls = [line.split('\t')[0] for line in lines]
counts = [int(line.split('\t')[1]) for line in lines]

# Plotting the bar chart
plt.barh(urls, counts, color='skyblue')
plt.xlabel('Count')
plt.title('URL Counts')
plt.tight_layout()

# Save the plot as an image or display it
plt.savefig('url_counts.png')
# plt.show()  # Uncomment this line to display the plot

plt.close()
