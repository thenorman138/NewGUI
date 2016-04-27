from tkinter import *




def win1():

    # creating login window
    window = Tk()

    photo = PhotoImage(file="shield-logo.gif")
    imgLabel = Label(window, image=photo)
    imgLabel.photo = photo
    imgLabel.place(relx=.1,rely=.1,anchor=CENTER)

    logoLabel = Label(window, text="IVY LEAGUE UNIVERSITY", font=("Times", 24, "bold"))
    logoLabel.place(relx=.4,rely=.1,anchor=CENTER)

    # defining label with text, and packing it into the window
    label = Label(window, text="Welcome to the Ivy League University Registration System!",font=("Helvetica", 14), fg="blue")
    label.place(relx=.5,rely=.35,anchor=CENTER)

    # secondary label
    label = Label(window, text="Please enter student ID and Password:")
    label.place(relx=.5,rely=.4,anchor=CENTER)

    # creating a textbox for user input, similar to textField in JavaFX


    label = Label(window, text="Username")
    label.place(relx=.32,rely=.5,anchor=CENTER)

    e1 = Entry(window)
    e1.place(relx=.5,rely=.5,anchor=CENTER)

    label = Label(window, text="Password")
    label.place(relx=.32,rely=.6, anchor=CENTER)

    e2 = Entry(window)
    e2.place(relx=.5,rely=.6,anchor=CENTER)

    # creating and setting button, including text and function, into the window
    button = Button(window, text="Continue", command=win2)
    button.place(relx=.5,rely=.8,anchor=CENTER)
    # button.grid(row=0,column=1)

    # The geometry function of tkinter in python assists with dimensions of the window
    window.geometry('800x600')
    window.title("Ivy League University - Registration")
    window.mainloop()



def win2():
    newwindow = Toplevel()
    newwindow.title("Semester Select")

    photo1 = PhotoImage(file = "shield-logo.gif")
    label3 = Label(newwindow, image = photo1)
    label3.image = photo1
    label3.place(relx=.1,rely=.1,anchor=CENTER)

    logoLabel1 = Label(newwindow, text="IVY LEAGUE UNIVERSITY", font=("Times", 24, "bold"))
    logoLabel1.place(relx=.4, rely=.1, anchor=CENTER)

    label1 = Label(newwindow, text="Welcome! Please select semester")
    label1.place(relx=.5,rely=.5,anchor=CENTER)

    var1 = StringVar(newwindow)
    dropdown = OptionMenu(newwindow, var1, 'Summer - 2016','Fall-2016')
    dropdown.config(width=20)
    dropdown.place(relx=.5,rely=.6,anchor=CENTER)

    button1 = Button(newwindow, text="Continue", command=win3)
    button1.place(relx=.5,rely=.8,anchor=CENTER)


    newwindow.geometry('800x600')


def win3():

    windowThree = Toplevel()
    windowThree.title("Class Select")

    photo2 = PhotoImage(file="shield-logo.gif")
    label4 = Label(windowThree, image=photo2)
    label4.image = photo2
    label4.place(relx=.1, rely=.1, anchor=CENTER)

    logoLabel2 = Label(windowThree, text="IVY LEAGUE UNIVERSITY", font=("Times", 24, "bold"))
    logoLabel2.place(relx=.4, rely=.1, anchor=CENTER)

    label2 = Label(windowThree, text="Please select your courses below:")
    label2.place(relx=.5,rely=.4,anchor=CENTER)



    ClassList = Listbox(windowThree)
    ClassList.insert(1,"10001 | ACCT | 1010 | Intro to Acct. | MWF | 9:15-10:45 | 3")
    ClassList.insert(2, "10002 | ART | 1010 | Art Hist. | TR | 1:15 - 2:45 | 3")
    ClassList.insert(3, "10003 | BIOL | 2010 | Intro to Bio II | TR | 9:15-10:45 | 3")
    ClassList.insert(4, "10004 | CHEM | 3610 | Chem. Formula Lab | MWF | 9:15-10:45 | 3")
    ClassList.insert(5, "10005 | CPSC | 2010 | Intro to Oper. Sys. | MWF | 9:15-10:45 | 3")
    ClassList.insert(6, "10006 | FIN | 1010 | Intro to Finance | TR | 1:15 - 2:45 | 3")
    ClassList.insert(7, "10007 | MATH | 3010 | Calculus II | MWF | 9:15-10:45 | 3")
    ClassList.insert(8, "10008 | STEM | 1010 | Intro to STEM | TR | 1:15 - 2:45 | 3")
    ClassList.config(width=50)
    ClassList.place(relx=.5,rely=.7,anchor=CENTER)

    button2 = Button(windowThree, text="Continue", command=win4)
    button2.place(relx=.5, rely=.9, anchor=CENTER)


    windowThree.geometry('800x600')

def win4():

    windowFour = Toplevel()
    windowFour.title("Confirmation")

    photo3 = PhotoImage(file="shield-logo.gif")
    label5 = Label(windowFour, image=photo3)
    label5.image = photo3
    label5.place(relx=.1, rely=.1, anchor=CENTER)

    logoLabel3 = Label(windowFour, text="IVY LEAGUE UNIVERSITY", font=("Times", 24, "bold"))
    logoLabel3.place(relx=.4, rely=.1, anchor=CENTER)

    confirmlabel = Label(windowFour, text="Congratulations! You've successfully registered for:")
    confirmlabel.place(relx=.5,rely=.3,anchor=CENTER)


    windowFour.geometry('800x600')





win1()