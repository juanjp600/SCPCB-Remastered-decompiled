Function savegame%(arg0$)
    Local local0.fps_settings
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5.npcs
    Local local6.rooms
    Local local7.doors
    Local local8%
    Local local9%
    Local local10.decals
    Local local11.events
    Local local12.items
    Local local13%
    Local local14.itemtemplates
    local0 = (First fps_settings)
    If (playable = $00) Then
        Return $00
    EndIf
    If (((dropspeed > (local0\Field3[$00] * 0.02)) Or (dropspeed < (local0\Field3[$00] * -0.02))) <> 0) Then
        Return $00
    EndIf
    If (0.0 > killtimer) Then
        Return $00
    EndIf
    gamesaved = $01
    createdir(arg0)
    local8 = writefile((arg0 + "save.txt"))
    writestring(local8, currenttime())
    writestring(local8, currentdate())
    writeint(local8, playtime)
    writefloat(local8, entityx(collider, $00))
    writefloat(local8, entityy(collider, $00))
    writefloat(local8, entityz(collider, $00))
    writefloat(local8, entityx(head, $00))
    writefloat(local8, entityy(head, $00))
    writefloat(local8, entityz(head, $00))
    writestring(local8, (Str accesscode))
    writefloat(local8, entitypitch(collider, $00))
    writefloat(local8, entityyaw(collider, $00))
    writestring(local8, modcompatiblenumber)
    writefloat(local8, blinktimer)
    writefloat(local8, blinkeffect)
    writefloat(local8, blinkeffecttimer)
    writeint(local8, (Int deathtimer))
    writeint(local8, (Int blurtimer))
    writefloat(local8, healtimer)
    writebyte(local8, crouch)
    writefloat(local8, stamina)
    writefloat(local8, staminaeffect)
    writefloat(local8, staminaeffecttimer)
    writefloat(local8, eyestuck)
    writefloat(local8, eyeirritation)
    writefloat(local8, injuries)
    writefloat(local8, bloodloss)
    writefloat(local8, previnjuries)
    writefloat(local8, prevbloodloss)
    writestring(local8, deathmsg)
    For local3 = $00 To $05 Step $01
        writefloat(local8, scp1025state[local3])
    Next
    writefloat(local8, vomittimer)
    writebyte(local8, vomit)
    writefloat(local8, camerashaketimer)
    writefloat(local8, i_008\Field0)
    writebyte(local8, i_447\Field0)
    writefloat(local8, i_447\Field1)
    writebyte(local8, i_447\Field2)
    writefloat(local8, i_447\Field3)
    writebyte(local8, i_447\Field4)
    writefloat(local8, i_447\Field5)
    writebyte(local8, usedmorphine)
    writefloat(local8, morphinetimer)
    writefloat(local8, morphinehealamount)
    writefloat(local8, i_409\Field0)
    writebyte(local8, i_178\Field0)
    writebyte(local8, i_215\Field0)
    writefloat(local8, i_215\Field1)
    writefloat(local8, i_215\Field2)
    writebyte(local8, i_215\Field4)
    writebyte(local8, i_1033ru\Field2)
    writebyte(local8, i_1033ru\Field0)
    writebyte(local8, i_1033ru\Field1)
    writefloat(local8, i_1079\Field0)
    writebyte(local8, i_1079\Field1)
    writebyte(local8, i_1079\Field2)
    writebyte(local8, i_1079\Field3)
    writefloat(local8, i_207\Field0)
    writebyte(local8, i_500\Field0)
    writebyte(local8, i_402\Field0)
    writefloat(local8, i_402\Field1)
    writefloat(local8, i_357\Field0)
    writebyte(local8, chancetospawn005)
    writefloat(local8, mtf2timer)
    writebyte(local8, contained457)
    writefloat(local8, gasmaskblurtimer)
    writebyte(local8, wearinghelmet)
    For local3 = $00 To $04 Step $01
        If (selecteddifficulty = difficulties(local3)) Then
            writebyte(local8, local3)
            If (local3 = $04) Then
                writebyte(local8, selecteddifficulty\Field3)
                writebyte(local8, selecteddifficulty\Field2)
                writebyte(local8, selecteddifficulty\Field4)
                writebyte(local8, selecteddifficulty\Field5)
                writebyte(local8, selecteddifficulty\Field11)
                writebyte(local8, selecteddifficulty\Field10)
            EndIf
        EndIf
    Next
    writefloat(local8, monitortimer)
    writefloat(local8, sanity)
    writebyte(local8, wearinggasmask)
    writebyte(local8, wearingvest)
    writebyte(local8, wearinghazmat)
    writebyte(local8, wearingnightvision)
    writebyte(local8, i_1499\Field0)
    writefloat(local8, i_1499\Field1)
    writefloat(local8, i_1499\Field2)
    writefloat(local8, i_1499\Field3)
    writefloat(local8, i_1499\Field5)
    writefloat(local8, i_1499\Field6)
    writefloat(local8, i_1499\Field7)
    If (i_1499\Field4 <> Null) Then
        writefloat(local8, i_1499\Field4\Field3)
        writefloat(local8, i_1499\Field4\Field5)
    Else
        writefloat(local8, 0.0)
        writefloat(local8, 0.0)
    EndIf
    writebyte(local8, superman)
    writefloat(local8, supermantimer)
    writebyte(local8, lightson)
    writestring(local8, randomseed)
    writefloat(local8, secondarylighton)
    writefloat(local8, prevsecondarylighton)
    writebyte(local8, remotedooron)
    writebyte(local8, soundtransmission)
    writebyte(local8, contained106)
    For local3 = $00 To $3A Step $01
        writebyte(local8, achievements(local3))
    Next
    writeint(local8, refineditems)
    writeint(local8, mapwidth)
    writeint(local8, mapheight)
    For local9 = $00 To $00 Step $01
        For local1 = $00 To mapwidth Step $01
            For local2 = $00 To mapheight Step $01
                writeint(local8, maptemp(local1, local2))
                writebyte(local8, mapfound(local1, local2))
            Next
        Next
    Next
    writeint(local8, $71)
    local4 = $00
    For local5 = Each npcs
        local4 = (local4 + $01)
    Next
    writeint(local8, local4)
    For local5 = Each npcs
        writebyte(local8, local5\Field5)
        writefloat(local8, entityx(local5\Field4, $01))
        writefloat(local8, entityy(local5\Field4, $01))
        writefloat(local8, entityz(local5\Field4, $01))
        writefloat(local8, entitypitch(local5\Field4, $00))
        writefloat(local8, entityyaw(local5\Field4, $00))
        writefloat(local8, entityroll(local5\Field4, $00))
        writefloat(local8, local5\Field9)
        writefloat(local8, local5\Field10)
        writefloat(local8, local5\Field11)
        writeint(local8, local5\Field12)
        writeint(local8, local5\Field76)
        writebyte(local8, (Int local5\Field24))
        writefloat(local8, local5\Field27)
        writeint(local8, local5\Field26)
        writeint(local8, (Int local5\Field22))
        writefloat(local8, local5\Field15)
        writefloat(local8, local5\Field25)
        writeint(local8, local5\Field6)
        If (local5\Field31 <> Null) Then
            writeint(local8, local5\Field31\Field6)
        Else
            writeint(local8, $00)
        EndIf
        writefloat(local8, local5\Field33)
        writefloat(local8, local5\Field34)
        writefloat(local8, local5\Field35)
        writestring(local8, local5\Field23)
        writefloat(local8, animtime(local5\Field0))
        writeint(local8, local5\Field48)
        writefloat(local8, local5\Field62)
        writefloat(local8, local5\Field63)
        writeint(local8, local5\Field61)
        writestring(local8, local5\Field64)
        writefloat(local8, local5\Field65)
        writefloat(local8, local5\Field66)
        writefloat(local8, local5\Field67)
        writeint(local8, local5\Field69)
    Next
    writefloat(local8, mtftimer)
    For local3 = $00 To $06 Step $01
        If (mtfrooms[$00] <> Null) Then
            writestring(local8, mtfrooms[$00]\Field7\Field10)
        ElseIf (mtf2rooms[$00] <> Null) Then
            writestring(local8, mtf2rooms[$00]\Field7\Field10)
        Else
            writestring(local8, "a")
        EndIf
        writeint(local8, mtfroomstate[local3])
        writeint(local8, mtf2roomstate[local3])
    Next
    writeint(local8, $278)
    writeint(local8, room2gw_brokendoor)
    writefloat(local8, room2gw_x)
    writefloat(local8, room2gw_z)
    writebyte(local8, i_zone\Field0[$00])
    writebyte(local8, i_zone\Field0[$01])
    writebyte(local8, i_zone\Field1)
    writebyte(local8, i_zone\Field2)
    local4 = $00
    For local6 = Each rooms
        local4 = (local4 + $01)
    Next
    writeint(local8, local4)
    For local6 = Each rooms
        writeint(local8, local6\Field7\Field1)
        writeint(local8, local6\Field6)
        writefloat(local8, local6\Field3)
        writefloat(local8, local6\Field4)
        writefloat(local8, local6\Field5)
        writebyte(local8, local6\Field1)
        writeint(local8, local6\Field0)
        If (playerroom = local6) Then
            writebyte(local8, $01)
        Else
            writebyte(local8, $00)
        EndIf
        For local3 = $00 To $0B Step $01
            If (local6\Field22[local3] = Null) Then
                writeint(local8, $00)
            Else
                writeint(local8, local6\Field22[local3]\Field6)
            EndIf
        Next
        For local3 = $00 To $0A Step $01
            If (local6\Field20[local3] <> $00) Then
                If (0.0 < entitypitch(local6\Field20[local3], $01)) Then
                    writebyte(local8, $01)
                Else
                    writebyte(local8, $00)
                EndIf
            EndIf
        Next
        writebyte(local8, $02)
        If (local6\Field23 = Null) Then
            writebyte(local8, $00)
        Else
            writebyte(local8, $01)
            For local2 = $00 To $12 Step $01
                For local1 = $00 To $12 Step $01
                    writebyte(local8, local6\Field23\Field0[((local2 * $13) + local1)])
                    writebyte(local8, local6\Field23\Field1[((local2 * $13) + local1)])
                Next
            Next
        EndIf
        If (local6\Field11 = Null) Then
            writebyte(local8, $00)
        Else
            If (i_zone\Field1 = $00) Then
                writebyte(local8, $01)
            Else
                writebyte(local8, $02)
            EndIf
            For local2 = $00 To $09 Step $01
                For local1 = $00 To $09 Step $01
                    writebyte(local8, local6\Field11\Field3[((local2 * $0A) + local1)])
                Next
            Next
            writefloat(local8, entityx(local6\Field11\Field5, $01))
            writefloat(local8, entityy(local6\Field11\Field5, $01))
            writefloat(local8, entityz(local6\Field11\Field5, $01))
        EndIf
    Next
    writeint(local8, $3BA)
    local4 = $00
    For local7 = Each doors
        local4 = (local4 + $01)
    Next
    writeint(local8, local4)
    For local7 = Each doors
        writefloat(local8, entityx(local7\Field2, $01))
        writefloat(local8, entityy(local7\Field2, $01))
        writefloat(local8, entityz(local7\Field2, $01))
        writebyte(local8, local7\Field5)
        writefloat(local8, local7\Field7)
        writebyte(local8, local7\Field4)
        writebyte(local8, local7\Field21)
        writefloat(local8, entityx(local7\Field0, $01))
        writefloat(local8, entityz(local7\Field0, $01))
        If (local7\Field1 <> $00) Then
            writefloat(local8, entityx(local7\Field1, $01))
            writefloat(local8, entityz(local7\Field1, $01))
        Else
            writefloat(local8, 0.0)
            writefloat(local8, 0.0)
        EndIf
        writefloat(local8, (Float local7\Field10))
        writefloat(local8, local7\Field11)
        writebyte(local8, local7\Field23)
        writebyte(local8, local7\Field24)
    Next
    writeint(local8, $735)
    local4 = $00
    For local10 = Each decals
        local4 = (local4 + $01)
    Next
    writeint(local8, local4)
    For local10 = Each decals
        writeint(local8, local10\Field8)
        writefloat(local8, entityx(local10\Field0, $01))
        writefloat(local8, entityy(local10\Field0, $01))
        writefloat(local8, entityz(local10\Field0, $01))
        writefloat(local8, entitypitch(local10\Field0, $01))
        writefloat(local8, entityyaw(local10\Field0, $01))
        writefloat(local8, entityroll(local10\Field0, $01))
        writebyte(local8, local10\Field6)
        writeint(local8, local10\Field7)
        writefloat(local8, local10\Field2)
        writefloat(local8, local10\Field5)
        writefloat(local8, local10\Field4)
        writefloat(local8, local10\Field9)
        writefloat(local8, local10\Field10)
    Next
    local4 = $00
    For local11 = Each events
        local4 = (local4 + $01)
    Next
    writeint(local8, local4)
    For local11 = Each events
        writestring(local8, local11\Field0)
        writefloat(local8, local11\Field2)
        writefloat(local8, local11\Field3)
        writefloat(local8, local11\Field4)
        writefloat(local8, local11\Field5)
        writefloat(local8, entityx(local11\Field1\Field2, $00))
        writefloat(local8, entityz(local11\Field1\Field2, $00))
        writestring(local8, local11\Field15)
    Next
    local4 = $00
    For local12 = Each items
        local4 = (local4 + $01)
    Next
    writeint(local8, local4)
    For local12 = Each items
        writestring(local8, local12\Field3\Field0)
        writestring(local8, local12\Field3\Field1)
        writestring(local8, local12\Field0)
        writefloat(local8, entityx(local12\Field1, $01))
        writefloat(local8, entityy(local12\Field1, $01))
        writefloat(local8, entityz(local12\Field1, $01))
        writebyte(local8, local12\Field5)
        writebyte(local8, local12\Field6)
        writebyte(local8, local12\Field7)
        writefloat(local8, local12\Field8)
        writefloat(local8, entitypitch(local12\Field1, $00))
        writefloat(local8, entityyaw(local12\Field1, $00))
        writefloat(local8, local12\Field13)
        writebyte(local8, local12\Field15)
        If (selecteditem = local12) Then
            writebyte(local8, $01)
        Else
            writebyte(local8, $00)
        EndIf
        local13 = $00
        For local3 = $00 To (maxitemamount - $01) Step $01
            If (inventory(local3) = local12) Then
                local13 = $01
                Exit
            EndIf
        Next
        If (local13 <> 0) Then
            writebyte(local8, local3)
        Else
            writebyte(local8, $42)
        EndIf
        If (local12\Field3\Field12 <> $00) Then
            writefloat(local8, animtime(local12\Field2))
        EndIf
        writebyte(local8, local12\Field23)
        writeint(local8, local12\Field22)
        If (local12\Field3\Field7 = local12\Field17) Then
            writebyte(local8, $00)
        Else
            writebyte(local8, $01)
        EndIf
    Next
    local4 = $00
    For local12 = Each items
        If (local12\Field23 > $00) Then
            local4 = (local4 + $01)
        EndIf
    Next
    writeint(local8, local4)
    For local12 = Each items
        If (local12\Field23 > $00) Then
            writeint(local8, local12\Field22)
            For local3 = $00 To (local12\Field23 - $01) Step $01
                If (local12\Field21[local3] <> Null) Then
                    writeint(local8, local12\Field21[local3]\Field22)
                Else
                    writeint(local8, $FFFFFFFF)
                EndIf
            Next
        EndIf
    Next
    For local14 = Each itemtemplates
        writebyte(local8, local14\Field3)
    Next
    If (usedconsole <> 0) Then
        writeint(local8, $64)
    Else
        writeint(local8, $3E2)
    EndIf
    writefloat(local8, camerafogfar)
    writefloat(local8, storedcamerafogfar)
    writebyte(local8, i_427\Field0)
    writefloat(local8, i_427\Field1)
    writebyte(local8, i_714\Field0)
    writebyte(local8, maxitemamount)
    closefile(local8)
    If (ms\Field1 = $00) Then
        If (selecteddifficulty\Field4 = $02) Then
            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\General\Save2.ogg")))
        Else
            playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\General\Save1.ogg")))
        EndIf
        msg = scplang_getphrase("ingame.save5")
        msgtimer = 280.0
    EndIf
    Return $00
End Function
