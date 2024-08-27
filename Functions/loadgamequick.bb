Function loadgamequick%(arg0$)
    Local local0$
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    Local local5%
    Local local6$
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11.rooms
    Local local12.npcs
    Local local13.doors
    Local local14%
    Local local15%
    Local local16#
    Local local17#
    Local local18%
    Local local20%
    Local local21#
    Local local23.npcs
    Local local24%
    Local local25%
    Local local26%
    Local local27%
    Local local28%
    Local local29#
    Local local30#
    Local local31#
    Local local32%
    Local local33#
    Local local34%
    Local local35%
    Local local36#
    Local local37#
    Local local38#
    Local local39#
    Local local40%
    Local local41#
    Local local42%
    Local local43%
    Local local44.decals
    Local local45#
    Local local46#
    Local local47#
    Local local48.events
    Local local49.items
    Local local50$
    Local local51$
    Local local52$
    Local local53%
    Local local54%
    Local local55%
    Local local56%
    Local local57%
    Local local58.itemtemplates
    Local local59%
    Local local60.items
    Local local61%
    Local local62#
    Local local63.rooms
    Local local64#
    Local local65.securitycams
    Local local66#
    Local local67#
    local0 = ""
    debughud = $00
    gamesaved = $01
    chs\Field2 = $00
    chs\Field4 = $00
    i_008\Field1 = $00
    deafplayer = $00
    deaftimer = 0.0
    unabletomove = $00
    msg = ""
    i_end\Field2 = ""
    positionentity(collider, 0.0, 1000.0, 0.0, $01)
    resetentity(collider)
    local14 = readfile((arg0 + "save.txt"))
    local6 = readstring(local14)
    local6 = readstring(local14)
    dropspeed = -0.1
    headdropspeed = 0.0
    shake = 0.0
    currspeed = 0.0
    heartbeatvolume = 0.0
    camerashake = 0.0
    shake = 0.0
    lightflash = 0.0
    blurtimer = 0.0
    killtimer = 0.0
    falltimer = 0.0
    ms\Field1 = $00
    chs\Field0 = $00
    chs\Field1 = $00
    wireframe($00)
    playtime = readint(local14)
    hideentity(collider)
    hideentity(at\Field4[$05])
    hideentity(at\Field4[$08])
    hideentity(at\Field4[$09])
    local1 = readfloat(local14)
    local2 = readfloat(local14)
    local3 = readfloat(local14)
    positionentity(collider, local1, (local2 + 0.05), local3, $00)
    showentity(collider)
    local1 = readfloat(local14)
    local2 = readfloat(local14)
    local3 = readfloat(local14)
    positionentity(head, local1, (local2 + 0.05), local3, $00)
    resetentity(head)
    accesscode = (Int readstring(local14))
    local1 = readfloat(local14)
    local2 = readfloat(local14)
    rotateentity(collider, local1, local2, 0.0, $00)
    local6 = readstring(local14)
    local0 = local6
    blinktimer = readfloat(local14)
    blinkeffect = readfloat(local14)
    blinkeffecttimer = readfloat(local14)
    deathtimer = (Float readint(local14))
    blurtimer = (Float readint(local14))
    healtimer = readfloat(local14)
    crouch = readbyte(local14)
    stamina = readfloat(local14)
    staminaeffect = readfloat(local14)
    staminaeffecttimer = readfloat(local14)
    eyestuck = readfloat(local14)
    eyeirritation = readfloat(local14)
    injuries = readfloat(local14)
    bloodloss = readfloat(local14)
    previnjuries = readfloat(local14)
    prevbloodloss = readfloat(local14)
    deathmsg = readstring(local14)
    For local4 = $00 To $05 Step $01
        scp1025state[local4] = readfloat(local14)
    Next
    vomittimer = readfloat(local14)
    vomit = readbyte(local14)
    camerashaketimer = readfloat(local14)
    i_008\Field0 = readfloat(local14)
    i_447\Field0 = readbyte(local14)
    i_447\Field1 = readfloat(local14)
    i_447\Field2 = readbyte(local14)
    i_447\Field3 = readfloat(local14)
    i_447\Field4 = readbyte(local14)
    i_447\Field5 = readfloat(local14)
    usedmorphine = readbyte(local14)
    morphinetimer = readfloat(local14)
    morphinehealamount = readfloat(local14)
    i_409\Field0 = readfloat(local14)
    i_178\Field0 = readbyte(local14)
    i_215\Field0 = readbyte(local14)
    i_215\Field1 = readfloat(local14)
    i_215\Field2 = readfloat(local14)
    i_215\Field4 = readbyte(local14)
    i_1033ru\Field2 = readbyte(local14)
    i_1033ru\Field0 = readbyte(local14)
    i_1033ru\Field1 = readbyte(local14)
    i_1079\Field0 = readfloat(local14)
    i_1079\Field1 = readbyte(local14)
    i_1079\Field2 = readbyte(local14)
    i_1079\Field3 = readbyte(local14)
    i_207\Field0 = readfloat(local14)
    i_500\Field0 = readbyte(local14)
    i_402\Field0 = readbyte(local14)
    i_402\Field1 = readfloat(local14)
    i_357\Field0 = readfloat(local14)
    chancetospawn005 = readbyte(local14)
    mtf2timer = readfloat(local14)
    contained457 = readbyte(local14)
    gasmaskblurtimer = readfloat(local14)
    chs\Field3 = $00
    chs\Field5 = $00
    wearinghelmet = readbyte(local14)
    local15 = readbyte(local14)
    selecteddifficulty = difficulties(local15)
    If (local15 = $04) Then
        selecteddifficulty\Field3 = readbyte(local14)
        selecteddifficulty\Field2 = readbyte(local14)
        selecteddifficulty\Field4 = readbyte(local14)
        selecteddifficulty\Field5 = readbyte(local14)
        selecteddifficulty\Field11 = readbyte(local14)
        selecteddifficulty\Field10 = readbyte(local14)
    EndIf
    monitortimer = readfloat(local14)
    sanity = readfloat(local14)
    wearinggasmask = readbyte(local14)
    wearingvest = readbyte(local14)
    wearinghazmat = readbyte(local14)
    wearingnightvision = readbyte(local14)
    i_1499\Field0 = readbyte(local14)
    i_1499\Field1 = readfloat(local14)
    i_1499\Field2 = readfloat(local14)
    i_1499\Field3 = readfloat(local14)
    i_1499\Field5 = readfloat(local14)
    i_1499\Field6 = readfloat(local14)
    i_1499\Field7 = readfloat(local14)
    local16 = readfloat(local14)
    local17 = readfloat(local14)
    superman = readbyte(local14)
    supermantimer = readfloat(local14)
    lightson = readbyte(local14)
    randomseed = readstring(local14)
    secondarylighton = readfloat(local14)
    prevsecondarylighton = readfloat(local14)
    remotedooron = readbyte(local14)
    soundtransmission = readbyte(local14)
    contained106 = readbyte(local14)
    For local4 = $00 To $3A Step $01
        achievements(local4) = readbyte(local14)
    Next
    refineditems = readint(local14)
    mapwidth = readint(local14)
    mapheight = readint(local14)
    For local1 = 0.0 To (Float mapwidth) Step 1.0
        For local2 = 0.0 To (Float mapheight) Step 1.0
            maptemp((Int local1), (Int local2)) = readint(local14)
            mapfound((Int local1), (Int local2)) = readbyte(local14)
        Next
    Next
    If (readint(local14) <> $71) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 2.5)")
    EndIf
    For local12 = Each npcs
        removenpc(local12)
    Next
    local5 = readint(local14)
    For local4 = $01 To local5 Step $01
        local18 = readbyte(local14)
        local1 = readfloat(local14)
        local2 = readfloat(local14)
        local3 = readfloat(local14)
        local12 = createnpc(local18, local1, local2, local3)
        Select local18
            Case $08
                curr173 = local12
            Case $07
                curr106 = local12
            Case $06
                curr096 = local12
            Case $0A
                curr5131 = local12
            Case $1A
                curr650 = local12
            Case $05
                curr066 = local12
        End Select
        local1 = readfloat(local14)
        local2 = readfloat(local14)
        local3 = readfloat(local14)
        rotateentity(local12\Field4, local1, local2, local3, $00)
        local12\Field9 = readfloat(local14)
        local12\Field10 = readfloat(local14)
        local12\Field11 = readfloat(local14)
        local12\Field12 = readint(local14)
        local12\Field76 = readint(local14)
        local12\Field24 = (Float readbyte(local14))
        local12\Field27 = readfloat(local14)
        local12\Field26 = readint(local14)
        local12\Field22 = (Float readint(local14))
        local12\Field15 = readfloat(local14)
        local12\Field25 = readfloat(local14)
        forcesetnpcid(local12, readint(local14))
        local12\Field32 = readint(local14)
        local12\Field33 = readfloat(local14)
        local12\Field34 = readfloat(local14)
        local12\Field35 = readfloat(local14)
        local12\Field23 = readstring(local14)
        If (local12\Field23 <> "") Then
            local20 = loadtexture_strict(local12\Field23, $01)
            entitytexture(local12\Field0, local20, $00, $00)
        EndIf
        local21 = readfloat(local14)
        Select local18
            Case $07,$12,$06,$14,$13,$03,$04,$11,$1A,$17,$1C,$19,$16,$02,$01,$1D
                setanimtime(local12\Field0, local21, $00)
        End Select
        local12\Field14 = local21
        local12\Field48 = readint(local14)
        local12\Field62 = readfloat(local14)
        local12\Field63 = readfloat(local14)
        local12\Field61 = readint(local14)
        local12\Field64 = readstring(local14)
        local12\Field65 = readfloat(local14)
        local12\Field66 = readfloat(local14)
        local12\Field67 = readfloat(local14)
        If (local12\Field64 <> "") Then
            freeentity(local12\Field0)
            local12\Field0 = loadanimmesh_strict(local12\Field64, $00)
            scaleentity(local12\Field0, local12\Field65, local12\Field66, local12\Field67, $00)
            setanimtime(local12\Field0, local21, $00)
        EndIf
        local12\Field69 = readint(local14)
        If (local12\Field69 > $00) Then
            changenpctextureid(local12, (local12\Field69 - $01))
            setanimtime(local12\Field0, local21, $00)
        EndIf
    Next
    For local12 = Each npcs
        If (local12\Field32 <> $00) Then
            For local23 = Each npcs
                If (local23 <> local12) Then
                    If (local23\Field6 = local12\Field32) Then
                        local12\Field31 = local23
                    EndIf
                EndIf
            Next
        EndIf
    Next
    mtftimer = readfloat(local14)
    For local4 = $00 To $06 Step $01
        local6 = readstring(local14)
        If (local6 <> "a") Then
            For local11 = Each rooms
                If (local11\Field7\Field10 = local6) Then
                    mtfrooms[local4] = local11
                    mtf2rooms[local4] = local11
                EndIf
            Next
        EndIf
        mtfroomstate[local4] = readint(local14)
        mtf2roomstate[local4] = readint(local14)
    Next
    If (readint(local14) <> $278) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 1)")
    EndIf
    room2gw_brokendoor = readint(local14)
    room2gw_x = readfloat(local14)
    room2gw_z = readfloat(local14)
    If (local0 = modcompatiblenumber) Then
        i_zone\Field0[$00] = readbyte(local14)
        i_zone\Field0[$01] = readbyte(local14)
        i_zone\Field1 = readbyte(local14)
        i_zone\Field2 = readbyte(local14)
    EndIf
    local5 = readint(local14)
    For local4 = $01 To local5 Step $01
        local24 = readint(local14)
        local25 = readint(local14)
        local1 = readfloat(local14)
        local2 = readfloat(local14)
        local3 = readfloat(local14)
        local26 = readbyte(local14)
        local27 = readint(local14)
        local28 = readbyte(local14)
        If (local25 >= $168) Then
            local25 = (local25 - $168)
        EndIf
        For local11 = Each rooms
            If (((local1 = local11\Field3) And (local3 = local11\Field5)) <> 0) Then
                Exit
            EndIf
        Next
        For local1 = 0.0 To 11.0 Step 1.0
            local7 = readint(local14)
            If (local7 > $00) Then
                For local12 = Each npcs
                    If (local12\Field6 = local7) Then
                        local11\Field22[(Int local1)] = local12
                        Exit
                    EndIf
                Next
            EndIf
        Next
        For local1 = 0.0 To 11.0 Step 1.0
            local7 = readbyte(local14)
            If (local7 = $02) Then
                Exit
            ElseIf (local7 = $01) Then
                rotateentity(local11\Field20[(Int local1)], 78.0, entityyaw(local11\Field20[(Int local1)], $00), 0.0, $00)
            Else
                rotateentity(local11\Field20[(Int local1)], -78.0, entityyaw(local11\Field20[(Int local1)], $00), 0.0, $00)
            EndIf
        Next
        If (readbyte(local14) = $01) Then
            For local2 = 0.0 To 18.0 Step 1.0
                For local1 = 0.0 To 18.0 Step 1.0
                    readbyte(local14)
                    readbyte(local14)
                Next
            Next
        ElseIf (local11\Field23 <> Null) Then
            For local1 = 0.0 To 18.0 Step 1.0
                For local2 = 0.0 To 18.0 Step 1.0
                    If (local11\Field23\Field3[(Int ((local2 * 19.0) + local1))] <> $00) Then
                        freeentity(local11\Field23\Field3[(Int ((local2 * 19.0) + local1))])
                        local11\Field23\Field3[(Int ((local2 * 19.0) + local1))] = $00
                    EndIf
                    If (local11\Field23\Field4[(Int ((local2 * 19.0) + local1))] <> Null) Then
                        removewaypoint(local11\Field23\Field4[(Int ((local2 * 19.0) + local1))])
                        local11\Field23\Field4[(Int ((local2 * 19.0) + local1))] = Null
                    EndIf
                Next
            Next
            For local1 = 0.0 To 5.0 Step 1.0
                If (local11\Field23\Field2[(Int local1)] <> $00) Then
                    freeentity(local11\Field23\Field2[(Int local1)])
                    local11\Field23\Field2[(Int local1)] = $00
                EndIf
            Next
            Delete local11\Field23
            local11\Field23 = Null
        EndIf
        If (readbyte(local14) > $00) Then
            For local2 = 0.0 To 9.0 Step 1.0
                For local1 = 0.0 To 9.0 Step 1.0
                    readbyte(local14)
                Next
            Next
            local29 = readfloat(local14)
            local30 = readfloat(local14)
            local31 = readfloat(local14)
        ElseIf (local11\Field11 <> Null) Then
            destroyforest(local11\Field11)
            Delete local11\Field11
        EndIf
        If (local28 = $01) Then
            playerroom = local11
        EndIf
    Next
    For local11 = Each rooms
        If (((local16 = local11\Field3) And (local17 = local11\Field5)) <> 0) Then
            i_1499\Field4 = local11
            Exit
        EndIf
    Next
    If (readint(local14) <> $3BA) Then
        runtimeerror("Couldn't load the game, save file may be corrupted (error 2)")
    EndIf
    local5 = readint(local14)
    For local4 = $01 To local5 Step $01
        local1 = readfloat(local14)
        local2 = readfloat(local14)
        local3 = readfloat(local14)
        local32 = readbyte(local14)
        local33 = readfloat(local14)
        local34 = readbyte(local14)
        local35 = readbyte(local14)
        local36 = readfloat(local14)
        local37 = readfloat(local14)
        local38 = readfloat(local14)
        local39 = readfloat(local14)
        local40 = (Int readfloat(local14))
        local41 = readfloat(local14)
        local42 = readbyte(local14)
        local43 = readbyte(local14)
        For local13 = Each doors
            If (local1 = entityx(local13\Field2, $01)) Then
                If (local3 = entityz(local13\Field2, $01)) Then
                    If (local2 = entityy(local13\Field2, $01)) Then
                        local13\Field5 = local32
                        local13\Field7 = local33
                        local13\Field4 = local34
                        local13\Field21 = local35
                        local13\Field10 = local40
                        local13\Field11 = local41
                        local13\Field23 = local42
                        local13\Field24 = local43
                        positionentity(local13\Field0, local36, entityy(local13\Field0, $00), local37, $01)
                        If (local13\Field1 <> $00) Then
                            positionentity(local13\Field1, local38, entityy(local13\Field1, $00), local39, $01)
                        EndIf
                        Exit
                    EndIf
                EndIf
            EndIf
        Next
    Next
    If (readint(local14) <> $735) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 3)")
    EndIf
    For local44 = Each decals
        freeentity(local44\Field0)
        Delete local44
    Next
    local5 = readint(local14)
    For local4 = $01 To local5 Step $01
        local7 = readint(local14)
        local1 = readfloat(local14)
        local2 = readfloat(local14)
        local3 = readfloat(local14)
        local45 = readfloat(local14)
        local46 = readfloat(local14)
        local47 = readfloat(local14)
        local44 = createdecal(local7, local1, local2, local3, local45, local46, local47)
        local44\Field6 = readbyte(local14)
        local44\Field7 = readint(local14)
        local44\Field2 = readfloat(local14)
        local44\Field5 = readfloat(local14)
        local44\Field4 = readfloat(local14)
        local44\Field9 = readfloat(local14)
        local44\Field10 = readfloat(local14)
        scalesprite(local44\Field0, local44\Field2, local44\Field2)
        entityblend(local44\Field0, local44\Field6)
        entityfx(local44\Field0, local44\Field7)
    Next
    updatedecals()
    For local48 = Each events
        If (local48\Field9 <> $00) Then
            freesound_strict(local48\Field9)
        EndIf
        Delete local48
    Next
    local5 = readint(local14)
    For local4 = $01 To local5 Step $01
        local48 = (New events)
        local48\Field0 = readstring(local14)
        local48\Field2 = readfloat(local14)
        local48\Field3 = readfloat(local14)
        local48\Field4 = readfloat(local14)
        local48\Field5 = readfloat(local14)
        local1 = readfloat(local14)
        local3 = readfloat(local14)
        For local11 = Each rooms
            If (((local1 = entityx(local11\Field2, $00)) And (local3 = entityz(local11\Field2, $00))) <> 0) Then
                local48\Field1 = local11
                Exit
            EndIf
        Next
        local48\Field15 = readstring(local14)
        If (local48\Field0 = "room173") Then
            If (local48\Field1\Field19[$00] = $00) Then
                local48\Field1\Field19[$00] = createpivot($00)
                local48\Field1\Field19[$01] = createpivot($00)
            EndIf
        ElseIf (local48\Field0 = "room860") Then
            If (1.0 = local48\Field2) Then
                showentity(local48\Field1\Field11\Field5)
            EndIf
        EndIf
    Next
    For local49 = Each items
        removeitem(local49)
    Next
    local5 = readint(local14)
    For local4 = $01 To local5 Step $01
        local50 = readstring(local14)
        local51 = readstring(local14)
        local52 = readstring(local14)
        If (local51 = "50ct") Then
            local50 = "Quarter"
            local51 = "25ct"
        EndIf
        local1 = readfloat(local14)
        local2 = readfloat(local14)
        local3 = readfloat(local14)
        local53 = readbyte(local14)
        local54 = readbyte(local14)
        local55 = readbyte(local14)
        local56 = (Int readfloat(local14))
        local49 = createitem(local50, local51, local1, local2, local3, local53, local54, local55, (Float local56), $00)
        local49\Field0 = local52
        entitytype(local49\Field1, $03, $00)
        local1 = readfloat(local14)
        local2 = readfloat(local14)
        rotateentity(local49\Field1, local1, local2, 0.0, $00)
        local49\Field13 = readfloat(local14)
        local49\Field15 = readbyte(local14)
        If (local49\Field15 <> 0) Then
            hideentity(local49\Field1)
        EndIf
        local57 = readbyte(local14)
        If (local57 = $01) Then
            selecteditem = local49
        EndIf
        local57 = readbyte(local14)
        If (local57 < $42) Then
            inventory(local57) = local49
            itemamount = (itemamount + $01)
        EndIf
        For local58 = Each itemtemplates
            If (local58\Field1 = local51) Then
                If (local58\Field12 <> $00) Then
                    setanimtime(local49\Field2, readfloat(local14), $00)
                    Exit
                EndIf
            EndIf
        Next
        local49\Field23 = readbyte(local14)
        local49\Field22 = readint(local14)
        If (local49\Field22 > lastitemid) Then
            lastitemid = local49\Field22
        EndIf
        If (readbyte(local14) = $00) Then
            local49\Field17 = local49\Field3\Field7
        Else
            local49\Field17 = local49\Field3\Field8
        EndIf
    Next
    local5 = readint(local14)
    For local4 = $01 To local5 Step $01
        local59 = readint(local14)
        For local60 = Each items
            If (local60\Field22 = local59) Then
                local49 = local60
                Exit
            EndIf
        Next
        For local61 = $00 To (local49\Field23 - $01) Step $01
            local59 = readint(local14)
            If (local59 <> $FFFFFFFF) Then
                For local60 = Each items
                    If (local60\Field22 = local59) Then
                        local49\Field21[local61] = local60
                        Exit
                    EndIf
                Next
            EndIf
        Next
    Next
    For local58 = Each itemtemplates
        local58\Field3 = readbyte(local14)
    Next
    For local13 = Each doors
        If (local13\Field13 <> Null) Then
            local62 = 20.0
            For local11 = Each rooms
                local64 = entitydistance(local11\Field2, local13\Field0)
                If (local62 > local64) Then
                    local62 = local64
                    local63 = local11
                EndIf
            Next
            local13\Field13 = local63
        EndIf
    Next
    If (readint(local14) <> $3E2) Then
        usedconsole = $01
    EndIf
    For local65 = Each securitycams
        local65\Field15 = $00
    Next
    entitytexture(at\Field4[$03], at\Field5[$03], $00, $00)
    restoresanity = $01
    camerafogfar = readfloat(local14)
    storedcamerafogfar = readfloat(local14)
    If (0.0 = camerafogfar) Then
        camerafogfar = 6.0
    EndIf
    i_427\Field0 = readbyte(local14)
    i_427\Field1 = readfloat(local14)
    If (local0 = "5.5.4") Then
        i_zone\Field0[$00] = readbyte(local14)
        i_zone\Field0[$01] = readbyte(local14)
        i_zone\Field1 = readbyte(local14)
        i_zone\Field2 = readbyte(local14)
    EndIf
    i_714\Field0 = readbyte(local14)
    maxitemamount = readbyte(local14)
    closefile(local14)
    If (collider <> $00) Then
        If (playerroom <> Null) Then
            showentity(playerroom\Field2)
        EndIf
        showentity(collider)
        teleportentity(collider, entityx(collider, $00), (entityy(collider, $00) + 0.5), entityz(collider, $00), 0.3, $01, 2.0, $00)
        If (playerroom <> Null) Then
            hideentity(playerroom\Field2)
        EndIf
    EndIf
    updatedoorstimer = 0.0
    If (sky <> $00) Then
        freeentity(sky)
        sky = $00
    EndIf
    For local11 = Each rooms
        If (local11\Field7\Field10 = "gatea") Then
            If (local11\Field19[$00] <> $00) Then
                freeentity(local11\Field19[$00])
                local11\Field19[$00] = $00
                local66 = entityx(local11\Field19[$09], $01)
                local67 = entityz(local11\Field19[$09], $01)
                freeentity(local11\Field19[$09])
                local11\Field19[$09] = $00
                local11\Field19[$0A] = $00
                local11\Field19[$09] = createpivot($00)
                positionentity(local11\Field19[$09], local66, (local11\Field4 + (992.0 * roomscale)), local67, $01)
                entityparent(local11\Field19[$09], local11\Field2, $01)
                local66 = entityx(local11\Field19[$0D], $01)
                local67 = entityz(local11\Field19[$0D], $01)
                freeentity(local11\Field19[$0D])
                local11\Field19[$0D] = loadmesh_strict(scpmodding_processfilepath("GFX\map\gateawall1.b3d"), local11\Field2)
                positionentity(local11\Field19[$0D], local66, (local11\Field4 - (1045.0 * roomscale)), local67, $01)
                entitycolor(local11\Field19[$0D], 25.0, 25.0, 25.0)
                entitytype(local11\Field19[$0D], $01, $00)
                local66 = entityx(local11\Field19[$0E], $01)
                local67 = entityz(local11\Field19[$0E], $01)
                freeentity(local11\Field19[$0E])
                local11\Field19[$0E] = loadmesh_strict(scpmodding_processfilepath("GFX\map\gateawall2.b3d"), local11\Field2)
                positionentity(local11\Field19[$0E], local66, (local11\Field4 - (1045.0 * roomscale)), local67, $01)
                entitycolor(local11\Field19[$0E], 25.0, 25.0, 25.0)
                entitytype(local11\Field19[$0E], $01, $00)
            EndIf
            If (local11\Field19[$0C] <> $00) Then
                freeentity(local11\Field19[$0C])
                local11\Field19[$0C] = $00
                freeentity(local11\Field19[$11])
                local11\Field19[$11] = $00
            EndIf
        ElseIf (local11\Field7\Field10 = "gateb") Then
            If (local11\Field19[$00] <> $00) Then
                local66 = entityx(local11\Field19[$00], $01)
                local67 = entityz(local11\Field19[$00], $01)
                freeentity(local11\Field19[$00])
                local11\Field19[$00] = $00
                local11\Field19[$00] = createpivot(local11\Field2)
                positionentity(local11\Field19[$00], local66, (9767.0 * roomscale), local67, $01)
            EndIf
        EndIf
    Next
    camerafogmode(camera, $01)
    hidedistance = 15.0
    Return $00
End Function
