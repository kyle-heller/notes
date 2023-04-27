# Files

## Creating a file and writing to it

The File class supplies the basic methods to manipulate files. The following script opens a new textfile in "write" mode and then writes "Hello file!" to it:

```ruby
fname = "sample.txt"
somefile = File.open(fname, "w")
somefile.puts "Hello file!"
somefile.close
```

In the file directory from which you run this code, a sample.txt file should now appear, with the words "Hello file!" in it. Some notes:

1. I deliberately made this example more wordy than it needs to be to emphasize this: the first line sets fname to just a string that represents the filename. Again, fname is just the filename, not the actual file itself. This also works:

```ruby
somefile = File.open("sample.txt", "w")
somefile.puts "Hello file!"
somefile.close
```

2. The next line invokes the File class method open, which requires us to pass it two arguments: 1) the filename, represented by a String, and 2) the read/write mode. As you might guess, "w" stands for write.
   **Warning:** Using "w" mode on an existing file will erase the contents of that file. If you want to append to an existing file, use "a" as the second argument.

3. The File class has its own puts method. But this one prints to the file instead of to the screen. You can also use write, which does not include a newline character at the end of the string.

4. The close method finishes the writing process and prevents any further data operations on the file (though you can reopen it again).

### File.open vs open

If you remember back to the tweet-fetching introduction, we executed programs that wrote the contents of Wikipedia to a file on our hard disk:

```ruby
require "open-uri"

remote_base_url = "http://en.wikipedia.org/wiki"
remote_page_name = "Ada_Lovelace"
remote_full_url = remote_base_url + "/" + remote_page_name

remote_data = open(remote_full_url).read
my_local_file = open("my-downloaded-page.html", "w")

my_local_file.write(remote_data)
my_local_file.close
```

Notice how we didn't have to invoke the use of the File class. I purposefully omitted it then because I wanted to reduce the number of unfamiliar words and conventions in the introduction. Like puts, open is handled by the Kernel class. In this lesson, I've explicitly invoked it as a method of the File class just to make it more obvious that we're dealing with a local file rather than an input stream from a webpage.

So the code snippet above could be written thus:

```ruby
remote_data = open(remote_full_url).read
my_local_file = File.open("my-downloaded-page.html", "w")
```

### Block notation

Instead of assigning a file handle to a variable, like so:

```
somefile = File.open("sample.txt", "w")
somefile.puts "Hello file!"
somefile.close
```

You can use the block convention with File.open:

```ruby
File.open("sample.txt", "w"){ |somefile| somefile.puts "Hello file!"}
```

The file handle is automatically closed at the end of the block, so no need to call the close method. This is handy in cases when you only need to do all read or write to a file all in one go.

## Reading from a file

Reading a file uses the same File.open method as before. However, the second argument is an "r" instead of "w".

After the file is opened, you can use a variety of methods to read its content. The most obviously-named method is read, which grabs all the file's contents:

```ruby
file = File.open("sample.txt", "r")
contents = file.read
puts contents   #=> Lorem ipsum etc.

contents = file.read
puts contents   #=> ""
```

Every read operation begins where the last read operation ended. In the case where we've read the entire file (by not passing in a number), the second read call has nothing left to read.

Here's an example of read using the block format

```ruby
contents = File.open("sample.txt", "r"){ |file| file.read }
puts contents
#=>   Lorem ipsum etc.
```

## Using readline and readlines

When dealing with delimited files, such as comma-delimited text files, it's more convenient to read the file line by line. The readlines method can draw in all the content and automatically parse it as an array, splitting the file contents by the line breaks.

```ruby
File.open("sample.txt").readlines.each do |line|
   puts line
end
```

The method readline on the other hand, reads a singular line. Again, each read operation moves the file handle forward in the file. If you keep calling readline until you hit the end of the file and then call it again, you'll get an "end of file" error.

The File class (more specifically, the IO class that File inherits from) contains the eof? method, which returns true if there is no more data in the file to read.

The readline method is often used in conjunction with while or unless:

```ruby
file = File.open("sample.txt", 'r')
while !file.eof?
   line = file.readline
   puts line
end
```

The readline method seems to require more upkeep than readlines. So why use it when you plan on reading an entire file?

Because the latter loads the entire file at once into memory. For most files under a few dozen megabytes, that's probably manageable on your home computer. But this is not good practice if the program is running on a computer that is serving multiple users, especially if the file is massive.

The readline method may require a couple more lines of code, but it's more efficient in most scenarios when extracting something from each line; you aren't operating on the entire file contents at once, and you don't need to store the entirety of each line either.

## Closing files

Just as you can open a file for reading or writing, you can close them too. What happens if you don't close a file? Nothing too bad, usually. But try writing a large amount of data to a file and have the program finish immediately after the write operation. When viewing the file immediately after with an external text editor, you might notice that it appears to be incomplete. Re-open it a few seconds later and it should contain what you expect.

File write operations don't happen instantaneously, as disk access is bound by at least the laws of physics. As data queues up to be written, it sits in a memory buffer before actually being written to the hard disk.

A file's close method forces a flush of the pending data. And while "flush" has the real-world meaning of getting rid of waste, in programming, a "flush" merely pushes the data-to-be-written to where you want it to be: a file on the hard drive.

Similar to flushing in the real-world, doing a "flush" is good practice in programming because it frees up memory for the rest of your program and (ideally) ensures that that file is available for other processes to access.

You can close a File by calling its close method:

```ruby
datafile = File.open("sample.txt", "r")
lines = datafile.readlines
datafile.close

lines.each{ |line| puts line }
```

Or, you can pass a block into File.open. At the end of the block, the file is automatically closed:

```ruby
lines = File.open("sample.txt", "r"){ |datafile|
   datafile.readlines
}

lines.each{|line| puts line}
```

## File existence and properties

Besides reading and writing, the File and Dir classes have methods that can determine various properties of files, including size, its directory, and whether or not a file with a given name exists.

### File.exists?

This is a useful class method that checks whether a file or directory exists and returns true/false:

```ruby
if File.exists?(filename)
   puts "#{filename} exists"
end
```

I use it often to check whether a directory exists. If false, then I use the Dir.mkdir class method to create it:

```ruby
dirname = "data-files"
Dir.mkdir(dirname) unless File.exists?dirname
File.open("#{dirname}/new-file.txt", 'w'){|f| f.write('Hello world!')}
```

### The Dir class

The methods of the Dir class are useful in conjunction with file operations.

One of the most useful is Dir.glob, which takes in a directory name and/or a pattern with wildcards and returns an array of filenames:

```ruby
# count the files in my Downloads directory:
puts Dir.glob('Downloads/*').length   #=> 382

# count all files in my Downloads directory and in sub-directories
puts Dir.glob('Downloads/**/*').length   #=> 308858

# list just PDF files, either with .pdf or .PDF extensions:
puts Dir.glob('Downloads/*.{pdf,PDF}').join(",\n")

#=> Downloads/About Downloads.pdf,
#=> Downloads/blueprintcss-1-0-cheatsheet-4-2-gjms.pdf,
#=> Downloads/crafting-rails-applications_b3_0.pdf,
#=> Downloads/DOM166.pdf,
#=> Downloads/html5-cheat-sheet.pdf,
#=> Downloads/la_museum_free_days.pdf,
#=> Downloads/mbapm_rec-a.pdf,
#=> Downloads/mbapm_rec.pdf,
#=> Downloads/metaprogramming-ruby_p2_0.pdf,
#=> Downloads/mining-of-massive-datasets-book.pdf,
#=> Downloads/poignant-guide.pdf,
#=> Downloads/PrinterSchedule.pdf
```
