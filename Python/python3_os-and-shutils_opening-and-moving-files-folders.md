# OS and SHUTILS
`os` and `shutils` are built-in python modules for working with directories/folders etc on any operating system

## OS module


```python
w = open('test_file.txt', 'w+')
w.write('This is a test file.')
w.close()
```


```python
import os
```


```python
os.getcwd() # get current working directory
```




    '/home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules'




```python
os.listdir('/home') # list contents of specified directory
```




    ['neal']



## SHUTIL


```python
import shutil
```

### move


```python
shutil.move('test_file.txt','/home/neal/Documents') # shutil.move(src, destination)
```


    ---------------------------------------------------------------------------

    Error                                     Traceback (most recent call last)

    <ipython-input-16-110ea058670a> in <module>
    ----> 1 shutil.move('test_file.txt','/home/neal/Documents') # shutil.move(src, destination)
    

    /usr/lib/python3.9/shutil.py in move(src, dst, copy_function)
        802 
        803         if os.path.exists(real_dst):
    --> 804             raise Error("Destination path '%s' already exists" % real_dst)
        805     try:
        806         os.rename(src, real_dst)


    Error: Destination path '/home/neal/Documents/test_file.txt' already exists


### delete

#### *CAUTION: The following may irrevocably delete data, BE CAREFUL*
- `os.unlink(path)` deletes specified file
- `os.rmdir(path)` deletes specified directory IF EMPTY
- `shutil.rmtree(path)` remove files and folders at specified path REGARDLESS IF EMPTY OR NOT

A safer alternative to `rmtree` is to install & use the `send2trash` external module which will move the specified file/folder to your system trashcan rather than delete.


```python
import send2trash
```


```python
shutil.move('/home/neal/Documents/test_file.txt','/home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules')
```




    '/home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/test_file.txt'




```python
os.listdir()
```




    ['00-Collections-Module.ipynb',
     'test_file.txt',
     '06-Timing your code - timeit.ipynb',
     '01-Opening-and-Reading-Files-Folders.ipynb',
     '03-Math-and-Random-Module.ipynb',
     '08-Advanced-Python-Module-Exercise',
     '.ipynb_checkpoints',
     '05-Overview-of-Regular-Expressions.ipynb',
     'Example_Top_Level',
     'Untitled.ipynb',
     '04-Python Debugger (pdb).ipynb',
     '02-Datetime-Module.ipynb',
     '07-Unzipping-and-Zipping-Files.ipynb']




```python
send2trash.send2trash('test_file.txt')
```


```python
os.listdir()
```




    ['00-Collections-Module.ipynb',
     '06-Timing your code - timeit.ipynb',
     '01-Opening-and-Reading-Files-Folders.ipynb',
     '03-Math-and-Random-Module.ipynb',
     '08-Advanced-Python-Module-Exercise',
     '.ipynb_checkpoints',
     '05-Overview-of-Regular-Expressions.ipynb',
     'Example_Top_Level',
     'Untitled.ipynb',
     '04-Python Debugger (pdb).ipynb',
     '02-Datetime-Module.ipynb',
     '07-Unzipping-and-Zipping-Files.ipynb']



## walk
`walk` is a "directory tree generator" method of the `OS` module. For every directory in the specified path `walk` will generate a tuple containing `dirpath` (string), `dirname` (list), `filenames` (list)


```python
for folder, sub_folders, files in os.walk(os.getcwd()):
    print(f"Currently looking at {folder}")
    print("\n")
    print("The subfolders are:")
    for subfold in sub_folders:
        print(f"Subfolder: {subfold}")
        
    print("\n")
    print("The files are:")
    for file in files:
        print(f"Files: {file}")
```

    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules
    
    
    The subfolders are:
    Subfolder: 08-Advanced-Python-Module-Exercise
    Subfolder: .ipynb_checkpoints
    Subfolder: Example_Top_Level
    
    
    The files are:
    Files: 00-Collections-Module.ipynb
    Files: python3_os-and-shutils_opening-and-moving-files-folders.ipynb
    Files: 06-Timing your code - timeit.ipynb
    Files: 01-Opening-and-Reading-Files-Folders.ipynb
    Files: 03-Math-and-Random-Module.ipynb
    Files: 05-Overview-of-Regular-Expressions.ipynb
    Files: 04-Python Debugger (pdb).ipynb
    Files: 02-Datetime-Module.ipynb
    Files: 07-Unzipping-and-Zipping-Files.ipynb
    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/08-Advanced-Python-Module-Exercise
    
    
    The subfolders are:
    Subfolder: .ipynb_checkpoints
    Subfolder: extracted_content
    
    
    The files are:
    Files: unzip_me_for_instructions.zip
    Files: 07-Advanced-Modules-Exercise-Puzzle.ipynb
    Files: 08-Advanced-Modules-Exercise-Solutions.ipynb
    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/08-Advanced-Python-Module-Exercise/.ipynb_checkpoints
    
    
    The subfolders are:
    
    
    The files are:
    Files: 08-Advanced-Modules-Exercise-Solutions-checkpoint.ipynb
    Files: 07-Advanced-Modules-Exercise-Puzzle-checkpoint.ipynb
    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/08-Advanced-Python-Module-Exercise/extracted_content
    
    
    The subfolders are:
    Subfolder: One
    Subfolder: Four
    Subfolder: Three
    Subfolder: Two
    Subfolder: Five
    
    
    The files are:
    Files: Instructions.txt
    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/08-Advanced-Python-Module-Exercise/extracted_content/One
    
    
    The subfolders are:
    
    
    The files are:
    Files: PHWAVPEKAER.txt
    Files: HMNZTLIFGPD.txt
    Files: HRQFTHKVJTL.txt
    Files: HVUTZEVMSBW.txt
    Files: JQUOBKFUACN.txt
    Files: PDJMSMNKIRM.txt
    Files: LPNDVDXPZIG.txt
    Files: KTXDHIOKAUI.txt
    Files: KCXGNQCZBLO.txt
    Files: KMMLGJOWLGI.txt
    Files: PTOBBCJYURJ.txt
    Files: LIFDHOFKWOI.txt
    Files: JTHSNBNPQSE.txt
    Files: KNBSKDREHQU.txt
    Files: HFUTPPAXDIS.txt
    Files: HDOHZHFSTTK.txt
    Files: LHODFIKVTQA.txt
    Files: PLYCGPVEAWO.txt
    Files: LFEATJAAYDC.txt
    Files: LDGOCUQJNNS.txt
    Files: PQNVCVJINAR.txt
    Files: KFIUZFERLET.txt
    Files: JLTXKIGCWDL.txt
    Files: JDLRVFCXYLU.txt
    Files: JEHBLZPUPSP.txt
    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/08-Advanced-Python-Module-Exercise/extracted_content/Four
    
    
    The subfolders are:
    
    
    The files are:
    Files: ECIOBYCDVFI.txt
    Files: ROICPTWKXDX.txt
    Files: TWUOYFCCYBQ.txt
    Files: QCTCKDIBBVG.txt
    Files: ESDIZXHYCVY.txt
    Files: EXVQSVBQQQH.txt
    Files: QCWCFLKNZMN.txt
    Files: RSXOTNGKBML.txt
    Files: WYDLGSGGXKV.txt
    Files: WFSKPTXPFCH.txt
    Files: EMTGPSXQEJX.txt
    Files: REAXWSOIQDY.txt
    Files: THPNEGKTJWI.txt
    Files: QDDETWBHJYC.txt
    Files: WNJISWPEBRS.txt
    Files: TJFMLJODVAD.txt
    Files: WXDJDOGZEHN.txt
    Files: QVNJULGXNUM.txt
    Files: WHTOHQUWXIN.txt
    Files: RXDARIDGKBF.txt
    Files: TAKNAVDMZKV.txt
    Files: RYNXFYXMKHG.txt
    Files: QTDYYIFPHAU.txt
    Files: TKCZSFQNJTX.txt
    Files: EPRNUHRSESC.txt
    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/08-Advanced-Python-Module-Exercise/extracted_content/Three
    
    
    The subfolders are:
    
    
    The files are:
    Files: VAQIJTDOFUJ.txt
    Files: VSXFSTABZDY.txt
    Files: XFHJOTNPEJG.txt
    Files: YQBIUHSUEVW.txt
    Files: VVKGWLRMHLU.txt
    Files: XVMPVSVYKFR.txt
    Files: VCFJCGJFBIH.txt
    Files: ZXIBJMPROKW.txt
    Files: XHZPVUQTXIO.txt
    Files: YQRNCMNFFHW.txt
    Files: ZEZKKRBIZEB.txt
    Files: YYIZGBTQHZP.txt
    Files: ZXEZRQXZNPG.txt
    Files: XJCWENFFGHB.txt
    Files: YCESZHJDBXH.txt
    Files: ZOWVXWPOGWP.txt
    Files: YDQFMWXOUMW.txt
    Files: XAJMCPEWFNI.txt
    Files: ZKQJXAYKPVD.txt
    Files: VVHFVZUNLOO.txt
    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/08-Advanced-Python-Module-Exercise/extracted_content/Two
    
    
    The subfolders are:
    
    
    The files are:
    Files: OHZOUOSFJQC.txt
    Files: GKQBQRCTNNK.txt
    Files: HMUTDOVNYTV.txt
    Files: OMWIMVRCMYM.txt
    Files: LVMBINRBJXL.txt
    Files: LSQSTGPIGIY.txt
    Files: HTOHSTYXTCO.txt
    Files: GTOTCIWMDBY.txt
    Files: HEORIXOTANT.txt
    Files: HARDNJGDRBC.txt
    Files: SWOFXREEHWA.txt
    Files: LYZEQCVYNEZ.txt
    Files: LCJZYDHBFRM.txt
    Files: SIKFPPLCJDN.txt
    Files: SOFUJYXTIMK.txt
    Files: OIHMLGMWTHL.txt
    Files: SPDZYGDHEWO.txt
    Files: GQTJJORZBXY.txt
    Files: GXYSEPAFRTP.txt
    Files: HMZXPBOPRAE.txt
    Files: GMMQQUBMJNR.txt
    Files: OYMAGXAGWHJ.txt
    Files: OKWFOOYTXFU.txt
    Files: LULTNYAQEJG.txt
    Files: SJMJLDGPBSJ.txt
    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/08-Advanced-Python-Module-Exercise/extracted_content/Five
    
    
    The subfolders are:
    
    
    The files are:
    Files: AEITMYIRQLP.txt
    Files: AQKATDFGXTS.txt
    Files: BUGKBZWRRVI.txt
    Files: EYTCGIOYWIW.txt
    Files: COMGMZBJAYE.txt
    Files: BVBURZZCAPR.txt
    Files: EAAOEPSAWMQ.txt
    Files: DYOPIIVMZOO.txt
    Files: EIPWXMQZJKU.txt
    Files: BSKJDRNEZQM.txt
    Files: DHZBAAYEADM.txt
    Files: CAHBEVSVDDN.txt
    Files: APJKSRITGGX.txt
    Files: BTYWAHLHKBM.txt
    Files: CSCLFZCDYYC.txt
    Files: AXJGVPVEFAS.txt
    Files: DZUWWXYIAEL.txt
    Files: DQPZQLBCJYP.txt
    Files: BNUQEHCFRTG.txt
    Files: ESIZWBHMGDP.txt
    Files: ETCUEXWNBCF.txt
    Files: DDLASODUVPX.txt
    Files: CXBVCTRBBIE.txt
    Files: ARLKFCWIAJE.txt
    Files: CRFSDGYFSHA.txt
    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/.ipynb_checkpoints
    
    
    The subfolders are:
    
    
    The files are:
    Files: 07-OS-Module-checkpoint.ipynb
    Files: 04-Timing your code - timeit-checkpoint.ipynb
    Files: 02-Datetime-Module-checkpoint.ipynb
    Files: 05-Overview-of-Regular-Expressions-checkpoint.ipynb
    Files: 09-Advanced-Modules-Exercise-Solutions-checkpoint.ipynb
    Files: 06-Timing your code - timeit-checkpoint.ipynb
    Files: 03-Math-and-Random-Module-checkpoint.ipynb
    Files: python3_os-and-shutils_opening-and-moving-files-folders-checkpoint.ipynb
    Files: 01-Opening-and-Reading-Files-Folders-checkpoint.ipynb
    Files: 01-Datetime-Module-checkpoint.ipynb
    Files: 02-Math-and-Random-Module-checkpoint.ipynb
    Files: 04-Python Debugger (pdb)-checkpoint.ipynb
    Files: 07-Unzipping-and-Zipping-Files-checkpoint.ipynb
    Files: 03-Python Debugger (pdb)-checkpoint.ipynb
    Files: 00-Collections-Module-checkpoint.ipynb
    Files: 06-Unzipping-and-Zipping-Files-checkpoint.ipynb
    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/Example_Top_Level
    
    
    The subfolders are:
    Subfolder: Mid-Example-One
    
    
    The files are:
    Files: Mid-Example.txt
    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/Example_Top_Level/Mid-Example-One
    
    
    The subfolders are:
    Subfolder: Bottom-Level-One
    Subfolder: Bottom-Level-Two
    
    
    The files are:
    Files: Mid-Level-Doc.txt
    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/Example_Top_Level/Mid-Example-One/Bottom-Level-One
    
    
    The subfolders are:
    
    
    The files are:
    Files: One_Text.txt
    Currently looking at /home/neal/Documents/udemy/complete-python-3/Complete-Python-3-Bootcamp/12-Advanced Python Modules/Example_Top_Level/Mid-Example-One/Bottom-Level-Two
    
    
    The subfolders are:
    
    
    The files are:
    Files: Bottom-Text-Two.txt





    <function os.walk(top, topdown=True, onerror=None, followlinks=False)>




```python
shutils.move(os.getcwd()+'/python3_os-and-shutils_opening-and-moving-files-folders.ipynb','/home/neal/Documents/python_notes/')
```
