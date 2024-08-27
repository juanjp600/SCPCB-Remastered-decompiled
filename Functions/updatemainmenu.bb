Function updatemainmenu%()
    Local local0.fonts
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6.fps_settings
    Local local8%
    Local local9%
    Local local10%
    Local local11$
    Local local14%
    Local local15%
    Local local18%
    Local local20%
    Local local21#
    Local local22#
    Local local23#
    Local local24#
    Local local25%
    Local local26%
    Local local28%
    Local local29#
    Local local30.sound
    Local local31%
    Local local32$
    Local local33%
    Local local34%
    Local local36.aafont
    local0 = (First fonts)
    local6 = (First fps_settings)
    color($00, $00, $00)
    rect($00, $00, graphicwidth, graphicheight, $01)
    showpointer()
    drawimage(menuback, $00, $00, $00)
    If ((millisecs2() Mod menublinktimer($00)) >= rand(menublinkduration($00), $01)) Then
    EndIf
    If (rand($12C, $01) = $01) Then
        ms\Field7[$00] = rand($FA0, $1F40)
        ms\Field8[$00] = rand($C8, $1F4)
    EndIf
    aasetfont(local0\Field0[$00])
    ms\Field7[$01] = (Int ((Float ms\Field7[$01]) - local6\Field3[$00]))
    If (ms\Field7[$01] < ms\Field8[$01]) Then
        color($32, $32, $32)
        aatext((ms\Field5 + rand($FFFFFFFB, $05)), (ms\Field6 + rand($FFFFFFFB, $05)), ms\Field4, $01, $00, 1.0)
        If (ms\Field7[$01] < $00) Then
            ms\Field7[$01] = rand($2BC, $320)
            ms\Field8[$01] = rand($0A, $23)
            ms\Field5 = (Int ((Float rand($2BC, $3E8)) * menuscale))
            ms\Field6 = (Int ((Float rand($64, $258)) * menuscale))
            Select rand($00, $17)
                Case $00,$02,$03
                    ms\Field4 = "DON'T BLINK"
                Case $04,$05
                    ms\Field4 = "Secure. Contain. Protect."
                Case $06,$07,$08
                    ms\Field4 = "You want happy endings? Fuck you."
                Case $09,$0A,$0B
                    ms\Field4 = "Sometimes we would have had time to scream."
                Case $0C,$13
                    ms\Field4 = "homosexuals are SCPs"
                Case $0D
                    ms\Field4 = "NO"
                Case $0E
                    ms\Field4 = "black white black white black white gray"
                Case $0F
                    ms\Field4 = "bentley is black"
                Case $10
                    ms\Field4 = "9341"
                Case $11
                    ms\Field4 = "It controls the doors"
                Case $12
                    ms\Field4 = "sharr's a fucking monkey"
                Case $14
                    ms\Field4 = "It has taken over everything"
                Case $15
                    ms\Field4 = "The spiral is growing"
                Case $16
                    ms\Field4 = ((chr($22) + "Some kind of gestalt effect due to massive reality damage.") + chr($22))
                Case $17
                    ms\Field4 = "SEBOTAN"
            End Select
        EndIf
    EndIf
    aasetfont(local0\Field0[$01])
    If (mousedown1 = $00) Then
        onsliderid = $00
    EndIf
    color($00, $00, $00)
    aatext(((graphicwidth Sar $01) + $03), (Int (((Float (graphicheight / $07)) * menuscale) + 3.0)), scpmodding_getgametitle(), $01, $00, 1.0)
    color($FF, $FF, $FF)
    aatext((graphicwidth Sar $01), (Int ((Float (graphicheight / $07)) * menuscale)), scpmodding_getgametitle(), $01, $00, 1.0)
    If (ms\Field3 = $00) Then
        For local8 = $00 To $03 Step $01
            local5 = $00
            local9 = $00
            local1 = (Int ((Float (graphicwidth Sar $01)) - (200.0 * menuscale)))
            local2 = (Int ((Float (($64 * local8) + $11E)) * menuscale))
            local3 = (Int (400.0 * menuscale))
            local4 = (Int (70.0 * menuscale))
            If (mouseon(local1, local2, local3, local4) <> 0) Then
                local9 = $01
                If (((mousehit1 And (local10 = $00)) Or (mouseup1 And local10)) <> 0) Then
                    local5 = $01
                    playsound_strict(buttonsfx)
                EndIf
            EndIf
            local5 = (mousehit1 And mouseon(local1, local2, local3, local4))
            Select local8
                Case $00
                    local11 = scplang_getphrase("menu.newgame")
                    randomseed = ""
                    If (local5 <> 0) Then
                        If (rand($0F, $01) = $01) Then
                            Select rand($0F, $01)
                                Case $01
                                    randomseed = "NIL"
                                Case $02
                                    randomseed = "NO"
                                Case $03
                                    randomseed = "d9341"
                                Case $04
                                    randomseed = "5CP_I73"
                                Case $05
                                    randomseed = "DONTBLINK"
                                Case $06
                                    randomseed = "CRUNCH"
                                Case $07
                                    randomseed = "die"
                                Case $08
                                    randomseed = "HTAED"
                                Case $09
                                    randomseed = "rustledjim"
                                Case $0A
                                    randomseed = "larry"
                                Case $0B
                                    randomseed = "JORGE"
                                Case $0C
                                    randomseed = "dirtymetal"
                                Case $0D
                                    randomseed = "whatpumpkin"
                                Case $0E
                                    randomseed = "the matrix"
                                Case $0F
                                    randomseed = "Walter White"
                            End Select
                        Else
                            local14 = rand($04, $08)
                            For local8 = $01 To local14 Step $01
                                If (rand($03, $01) = $01) Then
                                    randomseed = (randomseed + (Str rand($00, $09)))
                                Else
                                    randomseed = (randomseed + chr(rand($61, $7A)))
                                EndIf
                            Next
                        EndIf
                        ms\Field3 = $01
                    EndIf
                Case $01
                    local11 = scplang_getphrase("menu.loadgame")
                    If (local5 <> 0) Then
                        loadsavegames()
                        ms\Field3 = $02
                    EndIf
                Case $02
                    local11 = scplang_getphrase("menu.options")
                    If (local5 <> 0) Then
                        ms\Field3 = $03
                    EndIf
                Case $03
                    local11 = scplang_getphrase("menu.quit")
                    If (local5 <> 0) Then
                        fsound_stream_stop(currmusicstream)
                        scpsteam_shutdown()
                        end()
                    EndIf
            End Select
            If ((local9 And (rand($14, $01) = $01)) <> 0) Then
                color((rand($32, $01) + $64), $64, $64)
                aatext((Int (((Float rand($FFFFFFF6, $0A)) * menuscale) + (Float (graphicwidth Sar $01)))), (Int (((Float rand($FFFFFFF6, $0A)) * menuscale) + (Float local2))), local11, $01, $00, 1.0)
            EndIf
            color($00, $00, $00)
            aatext((Int ((3.0 * menuscale) + (Float (graphicwidth Sar $01)))), (Int ((3.0 * menuscale) + (Float local2))), local11, $01, $00, 1.0)
            If (local9 = $00) Then
                color($FF, $FF, $FF)
            Else
                color($E6, $23, $15)
            EndIf
            aatext((graphicwidth Sar $01), local2, local11, $01, $00, 1.0)
        Next
    Else
        local1 = (Int (159.0 * menuscale))
        local2 = (Int (286.0 * menuscale))
        local3 = (Int (400.0 * menuscale))
        local4 = (Int (70.0 * menuscale))
        If (ms\Field3 <> $08) Then
            If ((mouseon((Int ((330.0 * menuscale) + (Float (graphicwidth Sar $01)))), local2, $82, $3C) And (rand($14, $01) = $01)) <> 0) Then
                color((rand($32, $01) + $64), $64, $64)
                aatext((Int ((((330.0 * menuscale) + (Float (graphicwidth Sar $01))) + (3.0 * menuscale)) + (Float rand((Int (-10.0 * menuscale)), (Int (10.0 * menuscale)))))), (Int ((Float rand((Int (-10.0 * menuscale)), (Int (10.0 * menuscale)))) + ((3.0 * menuscale) + (Float local2)))), scplang_getphrase("menu.back"), $00, $00, 1.0)
            EndIf
            color($00, $00, $00)
            aatext((Int (((330.0 * menuscale) + (Float (graphicwidth Sar $01))) + (3.0 * menuscale))), (Int ((3.0 * menuscale) + (Float local2))), scplang_getphrase("menu.back"), $00, $00, 1.0)
            If (mouseon((Int ((330.0 * menuscale) + (Float (graphicwidth Sar $01)))), local2, $82, $3C) <> 0) Then
                color($E6, $23, $15)
                If (mousehit1 <> 0) Then
                    local15 = $01
                    playsound_strict(buttonsfx)
                EndIf
            Else
                color($FF, $FF, $FF)
            EndIf
            aatext((Int ((330.0 * menuscale) + (Float (graphicwidth Sar $01)))), local2, scplang_getphrase("menu.back"), $00, $00, 1.0)
        EndIf
        If (local15 <> 0) Then
            Select ms\Field3
                Case $01
                    putinivalue("options.ini", "game", "intro enabled", (Str introenabled))
                    ms\Field3 = $00
                Case $02
                    currloadgamepage = $00
                    ms\Field3 = $00
                Case $03,$05,$06,$07
                    saveoptionsini()
                    usertrackcheck = $00
                    usertrackcheck2 = $00
                    antialias(opt_antialias)
                    ms\Field3 = $00
                Case $04
                    ms\Field3 = $01
                    currloadgamepage = $00
                    mousehit1 = $00
                Default
                    ms\Field3 = $00
            End Select
        EndIf
        Select ms\Field3
            Case $01
                local1 = (Int (159.0 * menuscale))
                local2 = (Int (286.0 * menuscale))
                local3 = (Int (400.0 * menuscale))
                local4 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(local0\Field0[$01])
                aatext((graphicwidth Sar $01), ((local4 Sar $01) + local2), scplang_getphrase("menu.newgame"), $01, $01, 1.0)
                local1 = (Int ((Float (graphicwidth Sar $01)) - (290.0 * menuscale)))
                local2 = (Int ((20.0 * menuscale) + (Float (local2 + local4))))
                local3 = (Int (580.0 * menuscale))
                local4 = (Int (330.0 * menuscale))
                aasetfont(local0\Field0[$00])
                aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), scplang_getphrase("menu.name"), $00, $00, 1.0)
                currsave = inputbox((Int ((150.0 * menuscale) + (Float local1))), (Int ((15.0 * menuscale) + (Float local2))), (Int (200.0 * menuscale)), (Int (30.0 * menuscale)), currsave, $01)
                currsave = left(currsave, $0F)
                currsave = replace(currsave, ":", "")
                currsave = replace(currsave, ".", "")
                currsave = replace(currsave, "/", "")
                currsave = replace(currsave, "\", "")
                currsave = replace(currsave, "<", "")
                currsave = replace(currsave, ">", "")
                currsave = replace(currsave, "|", "")
                currsave = replace(currsave, "?", "")
                currsave = replace(currsave, chr($22), "")
                currsave = replace(currsave, "*", "")
                color($FF, $FF, $FF)
                If (selectedmap = "") Then
                    aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((60.0 * menuscale) + (Float local2))), scplang_getphrase("menu.seed"), $00, $00, 1.0)
                    randomseed = left(inputbox((Int ((150.0 * menuscale) + (Float local1))), (Int ((55.0 * menuscale) + (Float local2))), (Int (200.0 * menuscale)), (Int (30.0 * menuscale)), randomseed, $03), $0F)
                Else
                    aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((60.0 * menuscale) + (Float local2))), scplang_getphrase("menu.map"), $00, $00, 1.0)
                    color($FF, $FF, $FF)
                    rect((Int ((150.0 * menuscale) + (Float local1))), (Int ((55.0 * menuscale) + (Float local2))), (Int (200.0 * menuscale)), (Int (30.0 * menuscale)), $01)
                    color($00, $00, $00)
                    rect((Int (((150.0 * menuscale) + (Float local1)) + 2.0)), (Int (((55.0 * menuscale) + (Float local2)) + 2.0)), (Int ((200.0 * menuscale) - 4.0)), (Int ((30.0 * menuscale) - 4.0)), $01)
                    color($FF, $00, $00)
                    If (len(selectedmap) > $0F) Then
                        aatext((Int (((150.0 * menuscale) + (Float local1)) + (100.0 * menuscale))), (Int (((55.0 * menuscale) + (Float local2)) + (15.0 * menuscale))), (left(selectedmap, $0E) + "..."), $01, $01, 1.0)
                    Else
                        aatext((Int (((150.0 * menuscale) + (Float local1)) + (100.0 * menuscale))), (Int (((55.0 * menuscale) + (Float local2)) + (15.0 * menuscale))), selectedmap, $01, $01, 1.0)
                    EndIf
                    If (drawbutton((Int ((370.0 * menuscale) + (Float local1))), (Int ((55.0 * menuscale) + (Float local2))), (Int (120.0 * menuscale)), (Int (30.0 * menuscale)), scplang_getphrase("menu.deselect"), $00, $00, $01) <> 0) Then
                        selectedmap = ""
                    EndIf
                EndIf
                aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((110.0 * menuscale) + (Float local2))), scplang_getphrase("menu.enableintro"), $00, $00, 1.0)
                introenabled = drawtick((Int ((280.0 * menuscale) + (Float local1))), (Int ((110.0 * menuscale) + (Float local2))), introenabled, $00)
                aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((150.0 * menuscale) + (Float local2))), scplang_getphrase("menu.difficulty"), $00, $00, 1.0)
                If (drawtick((Int ((20.0 * menuscale) + (Float local1))), (Int ((180.0 * menuscale) + (Float local2))), (selecteddifficulty = difficulties($00)), $00) <> 0) Then
                    selecteddifficulty = difficulties($00)
                EndIf
                color(difficulties($00)\Field6, difficulties($00)\Field7, difficulties($00)\Field8)
                aatext((Int ((60.0 * menuscale) + (Float local1))), (Int ((180.0 * menuscale) + (Float local2))), difficulties($00)\Field0, $00, $00, 1.0)
                If (drawtick((Int ((20.0 * menuscale) + (Float local1))), (Int ((210.0 * menuscale) + (Float local2))), (selecteddifficulty = difficulties($01)), $00) <> 0) Then
                    selecteddifficulty = difficulties($01)
                EndIf
                color(difficulties($01)\Field6, difficulties($01)\Field7, difficulties($01)\Field8)
                aatext((Int ((60.0 * menuscale) + (Float local1))), (Int ((210.0 * menuscale) + (Float local2))), difficulties($01)\Field0, $00, $00, 1.0)
                If (drawtick((Int ((20.0 * menuscale) + (Float local1))), (Int ((240.0 * menuscale) + (Float local2))), (selecteddifficulty = difficulties($02)), $00) <> 0) Then
                    selecteddifficulty = difficulties($02)
                EndIf
                color(difficulties($02)\Field6, difficulties($02)\Field7, difficulties($02)\Field8)
                aatext((Int ((60.0 * menuscale) + (Float local1))), (Int ((240.0 * menuscale) + (Float local2))), difficulties($02)\Field0, $00, $00, 1.0)
                If (unlockthaumiel = $00) Then
                    local18 = $01
                EndIf
                If (unlockthaumiel = $01) Then
                    local18 = $00
                EndIf
                If (drawtick((Int ((20.0 * menuscale) + (Float local1))), (Int ((270.0 * menuscale) + (Float local2))), (selecteddifficulty = difficulties($03)), local18) <> 0) Then
                    selecteddifficulty = difficulties($03)
                EndIf
                color(difficulties($03)\Field6, difficulties($03)\Field7, difficulties($03)\Field8)
                aatext((Int ((60.0 * menuscale) + (Float local1))), (Int ((270.0 * menuscale) + (Float local2))), difficulties($03)\Field0, $00, $00, 1.0)
                If (drawtick((Int ((20.0 * menuscale) + (Float local1))), (Int ((300.0 * menuscale) + (Float local2))), (selecteddifficulty = difficulties($04)), $00) <> 0) Then
                    selecteddifficulty = difficulties($04)
                EndIf
                color(difficulties($04)\Field6, difficulties($04)\Field7, difficulties($04)\Field8)
                aatext((Int ((60.0 * menuscale) + (Float local1))), (Int ((300.0 * menuscale) + (Float local2))), difficulties($04)\Field0, $00, $00, 1.0)
                color($FF, $FF, $FF)
                drawframe((Int ((150.0 * menuscale) + (Float local1))), (Int ((155.0 * menuscale) + (Float local2))), (Int (450.0 * menuscale)), (Int (170.0 * menuscale)), $00, $00)
                If (selecteddifficulty\Field9 <> 0) Then
                    selecteddifficulty\Field2 = drawtick((Int ((160.0 * menuscale) + (Float local1))), (Int ((165.0 * menuscale) + (Float local2))), selecteddifficulty\Field2, $00)
                    aatext((Int ((200.0 * menuscale) + (Float local1))), (Int ((165.0 * menuscale) + (Float local2))), scplang_getphrase("menu.permadeath"), $00, $00, 1.0)
                    If (drawtick((Int ((160.0 * menuscale) + (Float local1))), (Int ((195.0 * menuscale) + (Float local2))), ((selecteddifficulty\Field4 = $00) And (selecteddifficulty\Field2 = $00)), selecteddifficulty\Field2) <> 0) Then
                        selecteddifficulty\Field4 = $00
                    Else
                        selecteddifficulty\Field4 = $02
                    EndIf
                    aatext((Int ((200.0 * menuscale) + (Float local1))), (Int ((195.0 * menuscale) + (Float local2))), scplang_getphrase("menu.saveanywhere"), $00, $00, 1.0)
                    selecteddifficulty\Field3 = drawtick((Int ((160.0 * menuscale) + (Float local1))), (Int ((225.0 * menuscale) + (Float local2))), selecteddifficulty\Field3, $00)
                    aatext((Int ((200.0 * menuscale) + (Float local1))), (Int ((225.0 * menuscale) + (Float local2))), scplang_getphrase("menu.aggressivenpcs"), $00, $00, 1.0)
                    aatext((Int ((200.0 * menuscale) + (Float local1))), (Int ((255.0 * menuscale) + (Float local2))), scplang_getphrase("menu.twoinventoryslots"), $00, $00, 1.0)
                    selecteddifficulty\Field11 = drawtick((Int ((160.0 * menuscale) + (Float local1))), (Int ((255.0 * menuscale) + (Float local2))), selecteddifficulty\Field11, $00)
                    color($FF, $FF, $FF)
                    drawimage(arrowimg($01), (Int ((155.0 * menuscale) + (Float local1))), (Int ((285.0 * menuscale) + (Float local2))), $00)
                    If (mousehit1 <> 0) Then
                        If (imagerectoverlap(arrowimg($01), (Int ((155.0 * menuscale) + (Float local1))), (Int ((285.0 * menuscale) + (Float local2))), scaledmousex(), scaledmousey(), $00, $00) <> 0) Then
                            If (selecteddifficulty\Field5 < $02) Then
                                selecteddifficulty\Field5 = (selecteddifficulty\Field5 + $01)
                            Else
                                selecteddifficulty\Field5 = $00
                            EndIf
                            playsound_strict(buttonsfx)
                        EndIf
                    EndIf
                    color($FF, $FF, $FF)
                    Select selecteddifficulty\Field5
                        Case $00
                            aatext((Int ((200.0 * menuscale) + (Float local1))), (Int ((285.0 * menuscale) + (Float local2))), scplang_getphrase("menu.otherfactors1"), $00, $00, 1.0)
                        Case $01
                            aatext((Int ((200.0 * menuscale) + (Float local1))), (Int ((285.0 * menuscale) + (Float local2))), scplang_getphrase("menu.otherfactors2"), $00, $00, 1.0)
                        Case $02
                            aatext((Int ((200.0 * menuscale) + (Float local1))), (Int ((285.0 * menuscale) + (Float local2))), scplang_getphrase("menu.otherfactors3"), $00, $00, 1.0)
                    End Select
                Else
                    rowtext(selecteddifficulty\Field1, (Int ((160.0 * menuscale) + (Float local1))), (Int ((160.0 * menuscale) + (Float local2))), (Int (420.0 * menuscale)), $C8, $00, 1.0)
                EndIf
                If (unlockthaumiel = $00) Then
                    If ((mouseon((Int ((20.0 * menuscale) + (Float local1))), (Int ((270.0 * menuscale) + (Float local2))), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((local1 + local3), (Int ((210.0 * menuscale) + (Float local2))), (Int (400.0 * menuscale)), (Int (150.0 * menuscale)), scplang_getphrase("menu.apollyon"), 0.0, $00)
                    EndIf
                EndIf
                If (drawbutton(local1, (Int ((20.0 * menuscale) + (Float (local2 + local4)))), (Int (160.0 * menuscale)), (Int (70.0 * menuscale)), scplang_getphrase("menu.loadmap"), $00, $00, $01) <> 0) Then
                    ms\Field3 = $04
                    loadsavedmaps()
                EndIf
                aasetfont(local0\Field0[$01])
                If (drawbutton((Int ((450.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float (local2 + local4)))), (Int (160.0 * menuscale)), (Int (70.0 * menuscale)), scplang_getphrase("menu.start"), $00, $00, $01) <> 0) Then
                    If (currsave = "") Then
                        currsave = scplang_getphrase("menu.untitled")
                    EndIf
                    If (randomseed = "") Then
                        randomseed = (Str (Abs millisecs()))
                    EndIf
                    seedrnd(generateseednumber(randomseed))
                    local20 = $00
                    For local8 = $01 To savegameamount Step $01
                        If (savegames((local8 - $01)) = currsave) Then
                            local20 = (local20 + $01)
                        EndIf
                    Next
                    If (local20 > $00) Then
                        currsave = (((currsave + " (") + (Str (local20 + $01))) + ")")
                    EndIf
                    loadentities()
                    loadallsounds()
                    initnewgame()
                    ms\Field0 = $00
                    flushkeys()
                    flushmouse()
                    putinivalue("options.ini", "game", "intro enabled", (Str introenabled))
                EndIf
            Case $02
                local2 = (Int ((20.0 * menuscale) + (Float (local2 + local4))))
                local3 = (Int (580.0 * menuscale))
                local4 = (Int (510.0 * menuscale))
                local1 = (Int (159.0 * menuscale))
                local2 = (Int (286.0 * menuscale))
                local3 = (Int (400.0 * menuscale))
                local4 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(local0\Field0[$01])
                aatext((graphicwidth Sar $01), ((local4 Sar $01) + local2), scplang_getphrase("menu.loadgame"), $01, $01, 1.0)
                local1 = (Int ((Float (graphicwidth Sar $01)) - (290.0 * menuscale)))
                local2 = (Int ((20.0 * menuscale) + (Float (local2 + local4))))
                local3 = (Int (580.0 * menuscale))
                local4 = (Int (296.0 * menuscale))
                aasetfont(local0\Field0[$01])
                If ((((Float currloadgamepage) < (ceil(((Float savegameamount) / 6.0)) - 1.0)) And (savemsg = "")) <> 0) Then
                    If (drawbutton((Int ((530.0 * menuscale) + (Float local1))), (Int ((510.0 * menuscale) + (Float local2))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), ">", $01, $00, $01) <> 0) Then
                        currloadgamepage = (currloadgamepage + $01)
                    EndIf
                Else
                    drawframe((Int ((530.0 * menuscale) + (Float local1))), (Int ((510.0 * menuscale) + (Float local2))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), $00, $00)
                    color($64, $64, $64)
                    aatext((Int ((555.0 * menuscale) + (Float local1))), (Int ((537.5 * menuscale) + (Float local2))), ">", $01, $01, 1.0)
                EndIf
                If (((currloadgamepage > $00) And (savemsg = "")) <> 0) Then
                    If (drawbutton(local1, (Int ((510.0 * menuscale) + (Float local2))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), "<", $01, $00, $01) <> 0) Then
                        currloadgamepage = (currloadgamepage - $01)
                    EndIf
                Else
                    drawframe(local1, (Int ((510.0 * menuscale) + (Float local2))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), $00, $00)
                    color($64, $64, $64)
                    aatext((Int ((25.0 * menuscale) + (Float local1))), (Int ((537.5 * menuscale) + (Float local2))), "<", $01, $01, 1.0)
                EndIf
                color($FF, $FF, $FF)
                aatext((Int (((Float local3) / 2.0) + (Float local1))), (Int ((536.0 * menuscale) + (Float local2))), ((((scplang_getphrase("menu.page") + " ") + (Str (Int max((Float (currloadgamepage + $01)), 1.0)))) + "/") + (Str (Int max((Float (Int ceil(((Float savegameamount) / 6.0)))), 1.0)))), $01, $01, 1.0)
                aasetfont(local0\Field0[$00])
                If ((Float currloadgamepage) > (ceil(((Float savegameamount) / 6.0)) - 1.0)) Then
                    currloadgamepage = (currloadgamepage - $01)
                EndIf
                If (savegameamount = $00) Then
                    aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), scplang_getphrase("menu.nosavedgames"), $00, $00, 1.0)
                Else
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    local2 = (Int ((20.0 * menuscale) + (Float local2)))
                    For local8 = (($06 * currloadgamepage) + $01) To (($06 * currloadgamepage) + $06) Step $01
                        If (local8 <= savegameamount) Then
                            If (((savegameversion((local8 - $01)) <> modcompatiblenumber) And (savegameversion((local8 - $01)) <> "5.5.4")) <> 0) Then
                                color($FF, $00, $00)
                            Else
                                color($FF, $FF, $FF)
                            EndIf
                            aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((10.0 * menuscale) + (Float local2))), savegames((local8 - $01)), $00, $00, 1.0)
                            aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((28.0 * menuscale) + (Float local2))), savegametime((local8 - $01)), $00, $00, 1.0)
                            aatext((Int ((120.0 * menuscale) + (Float local1))), (Int ((28.0 * menuscale) + (Float local2))), savegamedate((local8 - $01)), $00, $00, 1.0)
                            aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((46.0 * menuscale) + (Float local2))), scpmodding_version(), $00, $00, 1.0)
                            If (savemsg = "") Then
                                If (((savegameversion((local8 - $01)) <> modcompatiblenumber) And (savegameversion((local8 - $01)) <> "5.5.4")) <> 0) Then
                                    drawframe((Int ((280.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                                    color($FF, $00, $00)
                                    aatext((Int ((330.0 * menuscale) + (Float local1))), (Int ((34.0 * menuscale) + (Float local2))), scplang_getphrase("menu.load"), $01, $01, 1.0)
                                ElseIf (drawbutton((Int ((280.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), scplang_getphrase("menu.load"), $00, $00, $01) <> 0) Then
                                    loadentities()
                                    loadallsounds()
                                    loadgame((("Saves\" + savegames((local8 - $01))) + "\"))
                                    currsave = savegames((local8 - $01))
                                    initloadgame()
                                    ms\Field0 = $00
                                EndIf
                                If (drawbutton((Int ((400.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), scplang_getphrase("menu.delete"), $00, $00, $01) <> 0) Then
                                    savemsg = savegames((local8 - $01))
                                    Exit
                                EndIf
                            Else
                                drawframe((Int ((280.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                                If (((savegameversion((local8 - $01)) <> modcompatiblenumber) And (savegameversion((local8 - $01)) <> "5.5.4")) <> 0) Then
                                    color($FF, $00, $00)
                                Else
                                    color($64, $64, $64)
                                EndIf
                                aatext((Int ((330.0 * menuscale) + (Float local1))), (Int ((34.0 * menuscale) + (Float local2))), scplang_getphrase("menu.Load"), $01, $01, 1.0)
                                drawframe((Int ((400.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), $00, $00)
                                color($64, $64, $64)
                                aatext((Int ((450.0 * menuscale) + (Float local1))), (Int ((34.0 * menuscale) + (Float local2))), scplang_getphrase("menu.delete"), $01, $01, 1.0)
                            EndIf
                            local2 = (Int ((80.0 * menuscale) + (Float local2)))
                        Else
                            Exit
                        EndIf
                    Next
                    If (savemsg <> "") Then
                        local1 = (Int (740.0 * menuscale))
                        local2 = (Int (376.0 * menuscale))
                        drawframe(local1, local2, (Int (420.0 * menuscale)), (Int (200.0 * menuscale)), $00, $00)
                        rowtext(scplang_getphrase("menu.deletesaveconfirm"), (Int ((20.0 * menuscale) + (Float local1))), (Int ((15.0 * menuscale) + (Float local2))), (Int (400.0 * menuscale)), (Int (200.0 * menuscale)), $00, 1.0)
                        If (drawbutton((Int ((50.0 * menuscale) + (Float local1))), (Int ((150.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), scplang_getphrase("menu.yes"), $00, $00, $01) <> 0) Then
                            deletefile((((currentdir() + "Saves\") + savemsg) + "\save.txt"))
                            deletedir(((currentdir() + "Saves\") + savemsg))
                            savemsg = ""
                            loadsavegames()
                        EndIf
                        If (drawbutton((Int ((250.0 * menuscale) + (Float local1))), (Int ((150.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), scplang_getphrase("menu.no"), $00, $00, $01) <> 0) Then
                            savemsg = ""
                        EndIf
                    EndIf
                EndIf
            Case $03,$05,$06,$07
                local1 = (Int (159.0 * menuscale))
                local2 = (Int (286.0 * menuscale))
                local3 = (Int (400.0 * menuscale))
                local4 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(local0\Field0[$01])
                aatext((graphicwidth Sar $01), ((local4 Sar $01) + local2), scplang_getphrase("menu.options"), $01, $01, 1.0)
                local1 = (Int ((Float (graphicwidth Sar $01)) - (290.0 * menuscale)))
                local2 = (Int ((20.0 * menuscale) + (Float (local2 + local4))))
                local3 = (Int (580.0 * menuscale))
                local4 = (Int (60.0 * menuscale))
                color($00, $FF, $00)
                If (ms\Field3 = $03) Then
                    rect((Int ((15.0 * menuscale) + (Float local1))), (Int ((10.0 * menuscale) + (Float local2))), (Int ((Float (local3 / $05)) + (10.0 * menuscale))), (Int ((10.0 * menuscale) + (Float (local4 Sar $01)))), $01)
                ElseIf (ms\Field3 = $05) Then
                    rect((Int ((155.0 * menuscale) + (Float local1))), (Int ((10.0 * menuscale) + (Float local2))), (Int ((Float (local3 / $05)) + (10.0 * menuscale))), (Int ((10.0 * menuscale) + (Float (local4 Sar $01)))), $01)
                ElseIf (ms\Field3 = $06) Then
                    rect((Int ((295.0 * menuscale) + (Float local1))), (Int ((10.0 * menuscale) + (Float local2))), (Int ((Float (local3 / $05)) + (10.0 * menuscale))), (Int ((10.0 * menuscale) + (Float (local4 Sar $01)))), $01)
                ElseIf (ms\Field3 = $07) Then
                    rect((Int ((435.0 * menuscale) + (Float local1))), (Int ((10.0 * menuscale) + (Float local2))), (Int ((Float (local3 / $05)) + (10.0 * menuscale))), (Int ((10.0 * menuscale) + (Float (local4 Sar $01)))), $01)
                EndIf
                color($FF, $FF, $FF)
                If (drawbutton((Int ((20.0 * menuscale) + (Float local1))), (Int ((15.0 * menuscale) + (Float local2))), (local3 / $05), (local4 Sar $01), scplang_getphrase("menu.graphics"), $00, $00, $01) <> 0) Then
                    ms\Field3 = $03
                EndIf
                If (drawbutton((Int ((160.0 * menuscale) + (Float local1))), (Int ((15.0 * menuscale) + (Float local2))), (local3 / $05), (local4 Sar $01), scplang_getphrase("menu.audio"), $00, $00, $01) <> 0) Then
                    ms\Field3 = $05
                EndIf
                If (drawbutton((Int ((300.0 * menuscale) + (Float local1))), (Int ((15.0 * menuscale) + (Float local2))), (local3 / $05), (local4 Sar $01), scplang_getphrase("menu.controls"), $00, $00, $01) <> 0) Then
                    ms\Field3 = $06
                EndIf
                If (drawbutton((Int ((440.0 * menuscale) + (Float local1))), (Int ((15.0 * menuscale) + (Float local2))), (local3 / $05), (local4 Sar $01), scplang_getphrase("menu.advanced"), $00, $00, $01) <> 0) Then
                    ms\Field3 = $07
                EndIf
                aasetfont(local0\Field0[$00])
                local2 = (Int ((70.0 * menuscale) + (Float local2)))
                If (ms\Field3 <> $05) Then
                    usertrackcheck = $00
                    usertrackcheck2 = $00
                EndIf
                local21 = (Float (local1 + local3))
                local22 = (Float local2)
                local23 = (400.0 * menuscale)
                local24 = (150.0 * menuscale)
                If (ms\Field3 = $03) Then
                    local4 = (Int (410.0 * menuscale))
                    drawframe(local1, local2, local3, local4, $00, $00)
                    local2 = (Int ((20.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.bumpmapping"), $00, $00, 1.0)
                    local25 = bumpenabled
                    bumpenabled = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), bumpenabled, $00)
                    If (local25 <> bumpenabled) Then
                    EndIf
                    If ((mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "bump", 0.0, $00)
                    EndIf
                    local2 = (Int ((30.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.vsync"), $00, $00, 1.0)
                    vsync = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), vsync, $00)
                    If ((mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "vsync", 0.0, $00)
                    EndIf
                    local2 = (Int ((30.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.antialiasing"), $00, $00, 1.0)
                    opt_antialias = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), opt_antialias, $00)
                    If ((mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "antialias", 0.0, $00)
                    EndIf
                    local2 = (Int ((30.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.roomlights"), $00, $00, 1.0)
                    local26 = enableroomlights
                    enableroomlights = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), enableroomlights, $00)
                    If (local26 <> enableroomlights) Then
                    EndIf
                    If ((mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "roomlights", 0.0, $00)
                    EndIf
                    local2 = (Int ((30.0 * menuscale) + (Float local2)))
                    screengamma = (slidebar((Int ((310.0 * menuscale) + (Float local1))), (Int ((6.0 * menuscale) + (Float local2))), (Int (150.0 * menuscale)), (screengamma * 50.0)) / 50.0)
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.gamma"), $00, $00, 1.0)
                    If ((mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((6.0 * menuscale) + (Float local2))), (Int ((150.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "gamma", screengamma, $00)
                    EndIf
                    local2 = (Int ((50.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.particleamount"), $00, $00, 1.0)
                    particleamount = slider3((Int ((310.0 * menuscale) + (Float local1))), (Int ((6.0 * menuscale) + (Float local2))), (Int (150.0 * menuscale)), particleamount, $02, scplang_getphrase("menu.minimal"), scplang_getphrase("menu.reduced"), scplang_getphrase("menu.full"))
                    If (((mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) - (6.0 * menuscale))), (Int ((150.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) Or (onsliderid = $02)) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "particleamount", (Float particleamount), $00)
                    EndIf
                    local2 = (Int ((50.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.lodbias"), $00, $00, 1.0)
                    texturedetails = slider5((Int ((310.0 * menuscale) + (Float local1))), (Int ((6.0 * menuscale) + (Float local2))), (Int (150.0 * menuscale)), texturedetails, $03, "0.8", "0.4", "0.0", "-0.4", "-0.8")
                    Select texturedetails
                        Case $00
                            texturefloat = 0.8
                        Case $01
                            texturefloat = 0.4
                        Case $02
                            texturefloat = 0.0
                        Case $03
                            texturefloat = -0.4
                        Case $04
                            texturefloat = -0.8
                    End Select
                    texturelodbias(texturefloat)
                    If (((mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) - (6.0 * menuscale))), (Int ((150.0 * menuscale) + 14.0)), $14) And (onsliderid = $00)) Or (onsliderid = $03)) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int ((100.0 * menuscale) + local24)), "texquality", 0.0, $00)
                    EndIf
                    local2 = (Int ((50.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.vram"), $00, $00, 1.0)
                    local28 = savetexturesinvram
                    savetexturesinvram = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), savetexturesinvram, $00)
                    If (local28 <> savetexturesinvram) Then
                    EndIf
                    If ((mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) And (onsliderid = $00)) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "vram", 0.0, $00)
                    EndIf
                    local2 = (Int ((50.0 * menuscale) + (Float local2)))
                    local29 = (fov - 40.0)
                    local29 = (slidebar((Int ((310.0 * menuscale) + (Float local1))), (Int ((6.0 * menuscale) + (Float local2))), (Int (150.0 * menuscale)), (local29 * 2.0)) / 2.0)
                    fov = (local29 + 40.0)
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.fov"), $00, $00, 1.0)
                    color($FF, $FF, $00)
                    aatext((Int ((25.0 * menuscale) + (Float local1))), (Int ((25.0 * menuscale) + (Float local2))), ((Str (Int fov)) + " FOV"), $00, $00, 1.0)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((6.0 * menuscale) + (Float local2))), (Int ((150.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "fov", 0.0, $00)
                    EndIf
                ElseIf (ms\Field3 = $05) Then
                    local4 = (Int (220.0 * menuscale))
                    drawframe(local1, local2, local3, local4, $00, $00)
                    local2 = (Int ((20.0 * menuscale) + (Float local2)))
                    musicvolume = (slidebar((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) - (4.0 * menuscale))), (Int (150.0 * menuscale)), (musicvolume * 100.0)) / 100.0)
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.musicvolume"), $00, $00, 1.0)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) - (4.0 * menuscale))), (Int ((150.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "musicvol", musicvolume, $00)
                    EndIf
                    local2 = (Int ((40.0 * menuscale) + (Float local2)))
                    prevsfxvolume = (slidebar((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) - (4.0 * menuscale))), (Int (150.0 * menuscale)), (sfxvolume * 100.0)) / 100.0)
                    sfxvolume = prevsfxvolume
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.soundvolume"), $00, $00, 1.0)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) - (4.0 * menuscale))), (Int ((150.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "soundvol", prevsfxvolume, $00)
                    EndIf
                    local2 = (Int ((30.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.soundautorelease"), $00, $00, 1.0)
                    enablesfxrelease = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), enablesfxrelease, $00)
                    If (enablesfxrelease_prev <> enablesfxrelease) Then
                        If (enablesfxrelease <> 0) Then
                            For local30 = Each sound
                                For local8 = $00 To $1F Step $01
                                    If (local30\Field2[local8] <> $00) Then
                                        If (channelplaying(local30\Field2[local8]) <> 0) Then
                                            stopchannel(local30\Field2[local8])
                                        EndIf
                                    EndIf
                                Next
                                If (local30\Field0 <> $00) Then
                                    freesound(local30\Field0)
                                    local30\Field0 = $00
                                EndIf
                                local30\Field3 = $00
                            Next
                        Else
                            For local30 = Each sound
                                If (local30\Field0 = $00) Then
                                    local30\Field0 = loadsound(local30\Field1)
                                EndIf
                            Next
                        EndIf
                        enablesfxrelease_prev = enablesfxrelease
                    EndIf
                    If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int ((220.0 * menuscale) + local24)), "sfxautorelease", 0.0, $00)
                    EndIf
                    local2 = (Int ((30.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.usertracks"), $00, $00, 1.0)
                    enableusertracks = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), enableusertracks, $00)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "usertrack", 0.0, $00)
                    EndIf
                    If (enableusertracks <> 0) Then
                        local2 = (Int ((30.0 * menuscale) + (Float local2)))
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.trackmode"), $00, $00, 1.0)
                        usertrackmode = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), usertrackmode, $00)
                        If (usertrackmode <> 0) Then
                            aatext((Int ((350.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), scplang_getphrase("menu.repeat"), $00, $00, 1.0)
                        Else
                            aatext((Int ((350.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), scplang_getphrase("menu.random"), $00, $00, 1.0)
                        EndIf
                        If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                            drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "usertrackmode", 0.0, $00)
                        EndIf
                        If (drawbutton((Int ((20.0 * menuscale) + (Float local1))), (Int ((30.0 * menuscale) + (Float local2))), (Int (190.0 * menuscale)), (Int (25.0 * menuscale)), scplang_getphrase("menu.trackscan"), $00, $00, $01) <> 0) Then
                            usertrackcheck = $00
                            usertrackcheck2 = $00
                            local31 = readdir("SFX\Radio\UserTracks")
                            Repeat
                                local32 = nextfile(local31)
                                If (local32 = "") Then
                                    Exit
                                EndIf
                                If (filetype(("SFX\Radio\UserTracks" + local32)) = $01) Then
                                    usertrackcheck = (usertrackcheck + $01)
                                    local33 = loadsound(("SFX\Radio\UserTracks" + local32))
                                    If (local33 <> $00) Then
                                        usertrackcheck2 = (usertrackcheck2 + $01)
                                    EndIf
                                    freesound(local33)
                                EndIf
                            Forever
                            closedir(local31)
                        EndIf
                        If (mouseon((Int ((20.0 * menuscale) + (Float local1))), (Int ((30.0 * menuscale) + (Float local2))), (Int (190.0 * menuscale)), (Int (25.0 * menuscale))) <> 0) Then
                            drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "usertrackscan", 0.0, $00)
                        EndIf
                        If (usertrackcheck > $00) Then
                            aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((100.0 * menuscale) + (Float local2))), (((((((scplang_getphrase("menu.trackfound") + " (") + (Str usertrackcheck2)) + "/") + (Str usertrackcheck)) + " ") + scplang_getphrase("menu.successfullyloaded")) + ")"), $00, $00, 1.0)
                        EndIf
                    Else
                        usertrackcheck = $00
                    EndIf
                ElseIf (ms\Field3 = $06) Then
                    local4 = (Int (300.0 * menuscale))
                    drawframe(local1, local2, local3, local4, $00, $00)
                    local2 = (Int ((20.0 * menuscale) + (Float local2)))
                    mousesensitivity = ((slidebar((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) - (4.0 * menuscale))), (Int (150.0 * menuscale)), ((mousesensitivity + 0.5) * 100.0)) / 100.0) - 0.5)
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.mousesensitivity"), $00, $00, 1.0)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) - (4.0 * menuscale))), (Int ((150.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "mousesensitivity", mousesensitivity, $00)
                    EndIf
                    local2 = (Int ((40.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.invertmouse"), $00, $00, 1.0)
                    invertmouse = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), invertmouse, $00)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "mouseinvert", 0.0, $00)
                    EndIf
                    local2 = (Int ((40.0 * menuscale) + (Float local2)))
                    mouse_smooth = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), mouse_smooth, $00)
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.mousesmoothing"), $00, $00, 1.0)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) - (4.0 * menuscale))), (Int ((150.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "mousesmoothing", 0.0, $00)
                    EndIf
                    color($FF, $FF, $FF)
                    local2 = (Int ((30.0 * menuscale) + (Float local2)))
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.controlconfig"), $00, $00, 1.0)
                    local2 = (Int ((10.0 * menuscale) + (Float local2)))
                    aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), scplang_getphrase("menu.moveforward"), $00, $00, 1.0)
                    inputbox((Int ((160.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_up), 210.0))), $05)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((40.0 * menuscale) + (Float local2))), scplang_getphrase("menu.strafeleft"), $00, $00, 1.0)
                    inputbox((Int ((160.0 * menuscale) + (Float local1))), (Int ((40.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_left), 210.0))), $03)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((60.0 * menuscale) + (Float local2))), scplang_getphrase("menu.movebackward"), $00, $00, 1.0)
                    inputbox((Int ((160.0 * menuscale) + (Float local1))), (Int ((60.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_down), 210.0))), $06)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((80.0 * menuscale) + (Float local2))), scplang_getphrase("menu.straferight"), $00, $00, 1.0)
                    inputbox((Int ((160.0 * menuscale) + (Float local1))), (Int ((80.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_right), 210.0))), $04)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((100.0 * menuscale) + (Float local2))), scplang_getphrase("menu.quicksave"), $00, $00, 1.0)
                    inputbox((Int ((160.0 * menuscale) + (Float local1))), (Int ((100.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_save), 210.0))), $0B)
                    aatext((Int ((280.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), scplang_getphrase("menu.manualblink"), $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_blink), 210.0))), $07)
                    aatext((Int ((280.0 * menuscale) + (Float local1))), (Int ((40.0 * menuscale) + (Float local2))), scplang_getphrase("menu.sprint"), $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local1))), (Int ((40.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_sprint), 210.0))), $08)
                    aatext((Int ((280.0 * menuscale) + (Float local1))), (Int ((60.0 * menuscale) + (Float local2))), scplang_getphrase("menu.inventory"), $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local1))), (Int ((60.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_inv), 210.0))), $09)
                    aatext((Int ((280.0 * menuscale) + (Float local1))), (Int ((80.0 * menuscale) + (Float local2))), scplang_getphrase("menu.crouch"), $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local1))), (Int ((80.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_crouch), 210.0))), $0A)
                    If (canopenconsole <> 0) Then
                        aatext((Int ((280.0 * menuscale) + (Float local1))), (Int ((100.0 * menuscale) + (Float local2))), scplang_getphrase("menu.console"), $00, $00, 1.0)
                        inputbox((Int ((470.0 * menuscale) + (Float local1))), (Int ((100.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_console), 210.0))), $0C)
                    EndIf
                    aatext((Int ((280.0 * menuscale) + (Float local1))), (Int ((120.0 * menuscale) + (Float local2))), scplang_getphrase("menu.screenshot"), $00, $00, 1.0)
                    inputbox((Int ((470.0 * menuscale) + (Float local1))), (Int ((120.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (20.0 * menuscale)), keyname((Int min((Float key_screenshot), 210.0))), $0D)
                    If (mouseon((Int ((20.0 * menuscale) + (Float local1))), local2, (Int ((Float local3) - (40.0 * menuscale))), (Int (140.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "controls", 0.0, $00)
                    EndIf
                    For local8 = $00 To $E3 Step $01
                        If (keyhit(local8) <> 0) Then
                            local34 = local8
                            Exit
                        EndIf
                    Next
                    If (local34 <> $00) Then
                        Select selectedinputbox
                            Case $03
                                key_left = local34
                            Case $04
                                key_right = local34
                            Case $05
                                key_up = local34
                            Case $06
                                key_down = local34
                            Case $07
                                key_blink = local34
                            Case $08
                                key_sprint = local34
                            Case $09
                                key_inv = local34
                            Case $0A
                                key_crouch = local34
                            Case $0B
                                key_save = local34
                            Case $0C
                                key_console = local34
                            Case $0D
                                key_screenshot = local34
                        End Select
                        selectedinputbox = $00
                    EndIf
                ElseIf (ms\Field3 = $07) Then
                    local4 = (Int (370.0 * menuscale))
                    drawframe(local1, local2, local3, local4, $00, $00)
                    local2 = (Int ((20.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.hud"), $00, $00, 1.0)
                    hudenabled = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), hudenabled, $00)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "hud", 0.0, $00)
                    EndIf
                    local2 = (Int ((30.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.enableconsole"), $00, $00, 1.0)
                    canopenconsole = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), canopenconsole, $00)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "consoleenable", 0.0, $00)
                    EndIf
                    local2 = (Int ((30.0 * menuscale) + (Float local2)))
                    If (canopenconsole <> 0) Then
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.consoleonerror"), $00, $00, 1.0)
                        consoleopening = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), consoleopening, $00)
                        If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                            drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "consoleerror", 0.0, $00)
                        EndIf
                    Else
                        consoleopening = $00
                    EndIf
                    local2 = (Int ((30.0 * menuscale) + (Float local2)))
                    If (canopenconsole <> 0) Then
                        color($FF, $FF, $FF)
                        aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.consoleversion"), $00, $00, 1.0)
                        consoleversion = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), consoleversion, $00)
                        If (consoleversion = $01) Then
                            aatext((Int ((350.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.consolenew"), $00, $00, 1.0)
                        Else
                            aatext((Int ((350.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.consoleold"), $00, $00, 1.0)
                        EndIf
                        If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                            drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "consoleversion", 0.0, $00)
                        EndIf
                    EndIf
                    local2 = (Int ((50.0 * menuscale) + (Float local2)))
                    If (drawbutton((Int ((20.0 * menuscale) + (Float local1))), local2, $14A, $1E, scplang_getphrase("menu.resetstats"), $00, $00, $01) <> 0) Then
                        scpsteam_resetstats("1")
                    EndIf
                    local2 = (Int ((50.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.showfps"), $00, $00, 1.0)
                    showfps = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), showfps, $00)
                    If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "showfps", 0.0, $00)
                    EndIf
                    local2 = (Int ((30.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.framelimit"), $00, $00, 1.0)
                    color($FF, $FF, $FF)
                    If (drawtick((Int ((310.0 * menuscale) + (Float local1))), local2, (0.0 < currframelimit), $00) <> 0) Then
                        currframelimit = (slidebar((Int ((150.0 * menuscale) + (Float local1))), (Int ((30.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (currframelimit * 99.0)) / 99.0)
                        currframelimit = max(currframelimit, 0.01)
                        framelimit = (Int ((currframelimit * 100.0) + 19.0))
                        color($FF, $FF, $00)
                        aatext((Int ((25.0 * menuscale) + (Float local1))), (Int ((25.0 * menuscale) + (Float local2))), ((Str framelimit) + " FPS"), $00, $00, 1.0)
                    Else
                        currframelimit = 0.0
                        framelimit = $00
                    EndIf
                    If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "framelimit", (Float framelimit), $00)
                    EndIf
                    If (mouseon((Int ((150.0 * menuscale) + (Float local1))), (Int ((30.0 * menuscale) + (Float local2))), (Int ((100.0 * menuscale) + 14.0)), $14) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "framelimit", (Float framelimit), $00)
                    EndIf
                    local2 = (Int ((80.0 * menuscale) + (Float local2)))
                    color($FF, $FF, $FF)
                    aatext((Int ((20.0 * menuscale) + (Float local1))), local2, scplang_getphrase("menu.antialiasedtext"), $00, $00, 1.0)
                    aatextenable = drawtick((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), aatextenable, $00)
                    If (aatextenable_prev <> aatextenable) Then
                        For local36 = Each aafont
                            freefont(local36\Field6)
                            If (aatextenable = $00) Then
                                freetexture(local36\Field0)
                                freeimage(local36\Field1)
                            EndIf
                            Delete local36
                        Next
                        If (aatextenable = $00) Then
                            freeentity(aatextcam)
                        EndIf
                        initaafont()
                        local0\Field0[$00] = aaloadfont(scpmodding_processfilepath("GFX\font\cour\Courier New.ttf"), (Int (((Float graphicheight) / 1024.0) * 18.0)), $00, $00, $00, $02)
                        local0\Field0[$01] = aaloadfont(scpmodding_processfilepath("GFX\font\courbd\Courier New.ttf"), (Int (((Float graphicheight) / 1024.0) * 58.0)), $00, $00, $00, $02)
                        local0\Field0[$02] = aaloadfont(scpmodding_processfilepath("GFX\font\DS-DIGI\DS-Digital.ttf"), (Int (((Float graphicheight) / 1024.0) * 22.0)), $00, $00, $00, $02)
                        local0\Field0[$03] = aaloadfont(scpmodding_processfilepath("GFX\font\DS-DIGI\DS-Digital.ttf"), (Int (((Float graphicheight) / 1024.0) * 58.0)), $00, $00, $00, $02)
                        local0\Field0[$04] = aaloadfont(scpmodding_processfilepath("GFX\font\Journal\Journal.ttf"), (Int (((Float graphicheight) / 1024.0) * 58.0)), $00, $00, $00, $02)
                        local0\Field1 = aaloadfont("Blitz", (Int (((Float graphicheight) / 1024.0) * 22.0)), $00, $00, $00, $01)
                        aatextenable_prev = aatextenable
                    EndIf
                    If (mouseon((Int ((310.0 * menuscale) + (Float local1))), (Int ((Float local2) + menuscale)), (Int (20.0 * menuscale)), (Int (20.0 * menuscale))) <> 0) Then
                        drawoptionstooltip((Int local21), (Int local22), (Int local23), (Int local24), "antialiastext", 0.0, $00)
                    EndIf
                EndIf
            Case $04
                local2 = (Int ((20.0 * menuscale) + (Float (local2 + local4))))
                local3 = (Int (580.0 * menuscale))
                local4 = (Int (510.0 * menuscale))
                local1 = (Int (159.0 * menuscale))
                local2 = (Int (286.0 * menuscale))
                local3 = (Int (400.0 * menuscale))
                local4 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                aasetfont(local0\Field0[$01])
                aatext((graphicwidth Sar $01), ((local4 Sar $01) + local2), scplang_getphrase("menu.loadmap"), $01, $01, 1.0)
                local1 = (Int ((Float (graphicwidth Sar $01)) - (290.0 * menuscale)))
                local2 = (Int ((20.0 * menuscale) + (Float (local2 + local4))))
                local3 = (Int (580.0 * menuscale))
                local4 = (Int (350.0 * menuscale))
                aasetfont(local0\Field0[$01])
                local21 = (Float (local1 + local3))
                local22 = (Float local2)
                local23 = (400.0 * menuscale)
                local24 = (150.0 * menuscale)
                If ((Float currloadgamepage) < (ceil(((Float savedmapsamount) / 6.0)) - 1.0)) Then
                    If (drawbutton((Int ((530.0 * menuscale) + (Float local1))), (Int ((510.0 * menuscale) + (Float local2))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), ">", $01, $00, $01) <> 0) Then
                        currloadgamepage = (currloadgamepage + $01)
                    EndIf
                Else
                    drawframe((Int ((530.0 * menuscale) + (Float local1))), (Int ((510.0 * menuscale) + (Float local2))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), $00, $00)
                    color($64, $64, $64)
                    aatext((Int ((555.0 * menuscale) + (Float local1))), (Int ((537.5 * menuscale) + (Float local2))), ">", $01, $01, 1.0)
                EndIf
                If (currloadgamepage > $00) Then
                    If (drawbutton(local1, (Int ((510.0 * menuscale) + (Float local2))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), "<", $01, $00, $01) <> 0) Then
                        currloadgamepage = (currloadgamepage - $01)
                    EndIf
                Else
                    drawframe(local1, (Int ((510.0 * menuscale) + (Float local2))), (Int (50.0 * menuscale)), (Int (55.0 * menuscale)), $00, $00)
                    color($64, $64, $64)
                    aatext((Int ((25.0 * menuscale) + (Float local1))), (Int ((537.5 * menuscale) + (Float local2))), "<", $01, $01, 1.0)
                EndIf
                color($FF, $FF, $FF)
                aatext((Int (((Float local3) / 2.0) + (Float local1))), (Int ((536.0 * menuscale) + (Float local2))), ((((scplang_getphrase("menu.page") + " ") + (Str (Int max((Float (currloadgamepage + $01)), 1.0)))) + "/") + (Str (Int max((Float (Int ceil(((Float savedmapsamount) / 6.0)))), 1.0)))), $01, $01, 1.0)
                aasetfont(local0\Field0[$00])
                If ((Float currloadgamepage) > (ceil(((Float savedmapsamount) / 6.0)) - 1.0)) Then
                    currloadgamepage = (currloadgamepage - $01)
                EndIf
                If (savedmaps($00) = "") Then
                    aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), scplang_getphrase("menu.nosavedmaps"), $00, $00, 1.0)
                Else
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    local2 = (Int ((20.0 * menuscale) + (Float local2)))
                    For local8 = (($06 * currloadgamepage) + $01) To (($06 * currloadgamepage) + $06) Step $01
                        If (local8 <= savedmapsamount) Then
                            drawframe(local1, local2, (Int (540.0 * menuscale)), (Int (70.0 * menuscale)), $00, $00)
                            aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((10.0 * menuscale) + (Float local2))), savedmaps((local8 - $01)), $00, $00, 1.0)
                            aatext((Int ((20.0 * menuscale) + (Float local1))), (Int ((37.0 * menuscale) + (Float local2))), savedmapsauthor((local8 - $01)), $00, $00, 1.0)
                            If (drawbutton((Int ((400.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), scplang_getphrase("menu.load"), $00, $00, $01) <> 0) Then
                                selectedmap = savedmaps((local8 - $01))
                                ms\Field3 = $01
                            EndIf
                            If (mouseon((Int ((400.0 * menuscale) + (Float local1))), (Int ((20.0 * menuscale) + (Float local2))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale))) <> 0) Then
                                drawmapcreatortooltip((Int local21), (Int local22), (Int local23), (Int local24), savedmaps((local8 - $01)))
                            EndIf
                            local2 = (Int ((80.0 * menuscale) + (Float local2)))
                        Else
                            Exit
                        EndIf
                    Next
                EndIf
        End Select
    EndIf
    color($FF, $FF, $FF)
    aasetfont(local0\Field1)
    aatext($14, (graphicheight - $1E), ("SCP:CB Remastered " + scpmodding_version()), $00, $00, 1.0)
    If (fullscreen <> 0) Then
        drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
    EndIf
    aasetfont(local0\Field0[$00])
    Return $00
End Function
