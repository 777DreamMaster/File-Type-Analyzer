# File-Type-Analyzer

## Details
Project is a toolfor determining file type. It's not like determining file type based on the extension of the file; the filename can be random. Actually, many
file types contain special byte sequences that make it easy to determine them. This approach is widely used in many different applications. For example, the Unix “file” tool relies on a sophisticated “magic” database. Program parallelized to handle multiple files.

Progaram takes 2 arguments: 
- directory with files to analize
- patterns file for analizer
## Example
```
java Main test_files patterns.db
PDF.pdf: PDF document
word.doc: MS Office Word 2007+
ZIP.zip: Zip archive
```
