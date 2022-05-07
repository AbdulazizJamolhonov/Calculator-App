package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start()
    }

    @SuppressLint("SetTextI18n")
    private fun start() {
        all_clear.setOnClickListener {
            txt.text = "0"
            text.text = "0"
        }

        clear.setOnClickListener {
            if (txt.text.length == 1 && text.text == "0") {
                txt.text = "0"
            } else if (txt.text.length != 1 && text.text == "0") {
                txt.text = txt.text.substring(0, txt.text.length - 1)
            } else if (txt.text == "0" && text.text.length == 1) {
                text.text = "0"
            } else if (txt.text == "0" && text.text.length != 1) {
                text.text = text.text.substring(0, text.text.length - 1)
            } else if (txt.text.length != 1 && text.text.length == 1) {
                txt.text = txt.text.substring(0, txt.text.length - 1)
            } else if (txt.text.length == 1 && text.text.length == 1) {
                txt.text = "0"
            } else if (txt.text.length != 1 && text.text.length != 1) {
                txt.text = txt.text.substring(0, txt.text.length - 1)
            } else if (txt.text.length == 1 && text.text.length != 1) {
                txt.text = "0"
            }
//            if (txt.text.length != 1 && text.text.length != 1) {
//                text.text = text.text.substring(0, text.text.length - 1)
//            } else if (txt.text.length != 1 && text.text == "0") {
//                txt.text = txt.text.substring(0, txt.text.length - 1)
//            } else if (txt.text.length != 1 && text.text.length == 1) {
//                text.text = "0"
//            } else if (txt.text.length == 1 && text.text == "0") {
//                txt.text = "0"
//            }
        }

        plus_minus.setOnClickListener {
            if (txt.text.toString().toDouble() > 0.0) {
                val a = txt.text.reversed()
                val b = "$a-"
                val c = b.reversed()
                txt.text = c
            } else if (txt.text.toString().toDouble() < 0.0) {
                val a = txt.text.reversed()
                val b = a.substring(0, a.length - 1)
                val c = b.reversed()
                txt.text = c
            }
        }

        one.setOnClickListener {
            number("1")
        }

        two.setOnClickListener {
            number("2")
        }
        three.setOnClickListener {
            number("3")
        }
        four.setOnClickListener {
            number("4")
        }
        five.setOnClickListener {
            number("5")
        }
        six.setOnClickListener {
            number("6")
        }
        seven.setOnClickListener {
            number("7")
        }
        eight.setOnClickListener {
            number("8")
        }
        nine.setOnClickListener {
            number("9")
        }
        zero.setOnClickListener {
            number("0")
        }
        plus.setOnClickListener {
            actions("+")
        }
        minus.setOnClickListener {
            actions("-")
        }
        multiplication.setOnClickListener {
            actions("*")
        }
        division.setOnClickListener {
            actions("/")
//            if (text.text != "0") {
//                val a = text.text.substring(text.text.length - 1, text.text.length)
//                val b = text.text.substring(0, text.text.length - 1)
//                if (a == "+" || a == "-" || a == "*" || a == "/") {
//                    text.text = "$b/"
//                } else if (text.text.length > 20) {
//                    text.text = text.text.substring(0, text.text.length - 1)
//                } else {
//                    text.text = "${text.text}/"
//                }
//            }
        }

        point.setOnClickListener {
            var index = 0
            for (i in txt.text.indices) {
                if (txt.text[i] == '+' || txt.text[i] == '-' || txt.text[i] == '*' || txt.text[i] == '/') {
                    index = i
                }
            }
            if (index == 0 && !txt.text.toString().contains('.')) {
                txt.text = "${txt.text}."
            } else {
                if (!txt.text.toString().substring(index, txt.text.length).contains('.')) {
                    txt.text = "${txt.text}."
                }
            }
        }

        equals.setOnClickListener {
            start2()
        }
//            var action = ""
//            var index = -1
//
//            for (i in txt.text.indices) {
//                when (txt.text[i]) {
//                    '+' -> {
//                        action = "+"
//                        index = i
//                    }
//                    '-' -> {
//                        action = "-"
//                        index = i
//                    }
//                    '*' -> {
//                        action = "*"
//                        index = i
//                    }
//                    '/' -> {
//                        action = "/"
//                        index = i
//                    }
//                }
//            }
//
//            when (action) {
//                "+" -> {
//                    val javob =
//                        "${
//                            txt.text.substring(0, index).toInt() + txt.text.substring(
//                                index + 1,
//                                txt.text.length
//                            ).toInt()
//                        }"
//                    text.text = javob
//                }
//                "-" -> {
//                    val javob =
//                        "${
//                            txt.text.substring(0, index).toInt() - txt.text.substring(
//                                index + 1,
//                                txt.text.length
//                            ).toInt()
//                        }"
//                    text.text = javob
//                }
//                "*" -> {
//                    val javob =
//                        "${
//                            txt.text.substring(0, index).toInt() * txt.text.substring(
//                                index + 1,
//                                txt.text.length
//                            ).toInt()
//                        }"
//                    text.text = javob
//                }
//                "/" -> {
//                    val javob =
//                        "${
//                            txt.text.substring(0, index).toInt() / txt.text.substring(
//                                index + 1,
//                                txt.text.length
//                            ).toInt()
//                        }"
//                    text.text = javob
//                }
//            }
    }

    private fun start2() {
        try {
            val listNum = ArrayList<Double>()
            val listAct = ArrayList<String>()
            var index = 0

            for (i in txt.text.indices) {
                if (listAct.isEmpty()) {
                    when (txt.text[i]) {
                        '+' -> {
                            listNum.add(txt.text.substring(index, i).toDouble())
                            listAct.add("+")
                            index = i
                        }
                        '-' -> {
                            listNum.add(txt.text.substring(index, i).toDouble())
                            listAct.add("-")
                            index = i
                        }
                        '*' -> {
                            listNum.add(txt.text.substring(index, i).toDouble())
                            listAct.add("*")
                            index = i
                        }
                        '/' -> {
                            listNum.add(txt.text.substring(index, i).toDouble())
                            listAct.add("/")
                            index = i
                        }
                    }
                } else {
                    when (txt.text[i]) {
                        '+' -> {
                            listNum.add(txt.text.substring(index + 1, i).toDouble())
                            listAct.add("+")
                            index = i
                        }
                        '-' -> {
                            listNum.add(txt.text.substring(index + 1, i).toDouble())
                            listAct.add("-")
                            index = i
                        }
                        '*' -> {
                            listNum.add(txt.text.substring(index + 1, i).toDouble())
                            listAct.add("*")
                            index = i
                        }
                        '/' -> {
                            listNum.add(txt.text.substring(index + 1, i).toDouble())
                            listAct.add("/")
                            index = i
                        }
                    }
                }
            }

            listNum.add(txt.text.substring(index + 1, txt.text.length).toDouble())

            var count = 0
            var answer = listNum.first()
            while (count < listAct.size) {

                when (listAct[count]) {
                    "+" -> {
                        answer += listNum[count + 1]
                    }
                    "-" -> {
                        answer -= listNum[count + 1]
                    }
                    "*" -> {
                        answer *= listNum[count + 1]
                    }
                    "/" -> {
                        answer /= listNum[count + 1]
                    }
                }
                count++
            }
            if (answer / answer.toInt() == 1.0) {
                text.text = "${answer.toInt()}"
            } else {
                text.text = answer.toString()
            }
        } catch (e: Exception) {
            start()
        }
    }

    @SuppressLint("SetTextI18n")
    fun number(write: String) {
        if (txt.text != "0") {
            if (txt.text.length <= 36) {
                txt.text = "${txt.text}$write"
            }
        } else {
            txt.text = write
        }
    }

    @SuppressLint("SetTextI18n")
    fun actions(action: String) {
        when (action) {
            "+" -> {
                if (txt.text != "0" && txt.text.length < 36) {
                    val a = txt.text.substring(txt.text.length - 1, txt.text.length)
                    if (a == "+" || a == "-" || a == "*" || a == "/" && a != ".") {
                        txt.text = "${txt.text.substring(0, txt.text.length - 1)}+"
                    } else {
                        txt.text = "${txt.text}+"
                    }
                }
            }
            "-" -> {
                if (txt.text != "0" && txt.text.length < 36) {
                    val a = txt.text.substring(txt.text.length - 1, txt.text.length)
                    if (a == "+" || a == "-" || a == "*" || a == "/") {
                        txt.text = "${txt.text.substring(0, txt.text.length - 1)}-"
                    } else if (a != ".") {
                        txt.text = "${txt.text}-"
                    }
                }
            }
            "*" -> {
                if (txt.text != "0" && txt.text.length < 36) {
                    val a = txt.text.substring(txt.text.length - 1, txt.text.length)
                    if (a == "+" || a == "-" || a == "*" || a == "/") {
                        txt.text = "${txt.text.substring(0, txt.text.length - 1)}*"
                    } else if (a != ".") {
                        txt.text = "${txt.text}*"
                    }
                }
            }
            "/" -> {
                if (txt.text != "0" && txt.text.length < 36) {
                    val a = txt.text.substring(txt.text.length - 1, txt.text.length)
                    if (a == "+" || a == "-" || a == "*" || a == "/") {
                        txt.text = "${txt.text.substring(0, txt.text.length - 1)}/"
                    } else if (a != ".") {
                        txt.text = "${txt.text}/"
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_exit, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("SetTextI18n")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exit -> {
                txt.text = ""
                text.textSize = 50f
                text.text = "Exit = - \nContinue = + "

                one.isClickable = false
                two.isClickable = false
                three.isClickable = false
                four.isClickable = false
                five.isClickable = false
                six.isClickable = false
                seven.isClickable = false
                eight.isClickable = false
                nine.isClickable = false
                zero.isClickable = false
                clear.isClickable = false
                point.isClickable = false
                percent.isClickable = false
                multiplication.isClickable = false
                division.isClickable = false
                equals.isClickable = false
                plus_minus.isClickable = false
                all_clear.isClickable = false
                minus.setOnClickListener {
                    finish()
                }

                plus.setOnClickListener {
                    text.text = "0"
                    txt.text = "0"
                    one.isClickable = true
                    two.isClickable = true
                    three.isClickable = true
                    four.isClickable = true
                    five.isClickable = true
                    six.isClickable = true
                    seven.isClickable = true
                    eight.isClickable = true
                    nine.isClickable = true
                    zero.isClickable = true
                    clear.isClickable = true
                    point.isClickable = true
                    percent.isClickable = true
                    multiplication.isClickable = true
                    division.isClickable = true
                    equals.isClickable = true
                    plus_minus.isClickable = true
                    all_clear.isClickable = true
                    start()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}