Function nullgame%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4.itemtemplates
    Local local5.screens
    Local local6.lighttemplates
    Local local7.doors
    Local local8.materials
    Local local9.waypoints
    Local local10.tempwaypoints
    Local local11.rooms
    Local local12.items
    Local local13.objects
    Local local14.props
    Local local15.decals
    Local local16.npcs
    Local local17%
    Local local18.events
    Local local19.securitycams
    Local local20.emitters
    Local local21.particles
    Local local22.roomtemplates
    Local local23$
    Local local24%
    local13 = (First objects)
    killsounds()
    If (arg0 <> 0) Then
        playsound_strict(buttonsfx)
    EndIf
    freeparticles()
    cleartexturecache()
    debughud = $00
    unabletomove = $00
    quickloadpercent = $FFFFFFFF
    quickloadpercent_displaytimer = 0.0
    quickload_currevent = Null
    deathmsg = ""
    selectedmap = ""
    usedconsole = $00
    doortempid = $00
    roomtempid = $00
    gamesaved = $00
    hidedistance = 15.0
    For local3 = $00 To $00 Step $01
        For local1 = $00 To (mapwidth + $01) Step $01
            For local2 = $00 To (mapheight + $01) Step $01
                maptemp(local1, local2) = $00
                mapfound(local1, local2) = $00
            Next
        Next
    Next
    For local4 = Each itemtemplates
        local4\Field3 = $00
    Next
    dropspeed = 0.0
    shake = 0.0
    currspeed = 0.0
    deathtimer = 0.0
    heartbeatvolume = 0.0
    staminaeffect = 1.0
    staminaeffecttimer = 0.0
    blinkeffect = 1.0
    blinkeffecttimer = 0.0
    bloodloss = 0.0
    injuries = 0.0
    i_008\Field0 = 0.0
    For local0 = $00 To $05 Step $01
        scp1025state[local0] = 0.0
    Next
    i_end\Field2 = ""
    i_end\Field0 = 0.0
    explosiontimer = 0.0
    camerashake = 0.0
    shake = 0.0
    lightflash = 0.0
    chs\Field0 = $00
    chs\Field1 = $00
    wireframestate = $00
    wireframe($00)
    wearinggasmask = $00
    wearinghazmat = $00
    wearingvest = $00
    i_714\Field0 = $00
    If (wearingnightvision <> 0) Then
        camerafogfar = storedcamerafogfar
        wearingnightvision = $00
    EndIf
    i_427\Field0 = $00
    i_427\Field1 = 0.0
    forcemove = 0.0
    forceangle = 0.0
    playable = $01
    coffindistance = 100.0
    contained106 = $00
    If (curr173 <> Null) Then
        curr173\Field24 = 0.0
    EndIf
    mtftimer = 0.0
    For local0 = $00 To $09 Step $01
        mtfrooms[local0] = Null
        mtfroomstate[local0] = $00
    Next
    For local5 = Each screens
        If (local5\Field2 <> $00) Then
            freeimage(local5\Field2)
            local5\Field2 = $00
        EndIf
        Delete local5
    Next
    For local0 = $00 To $3A Step $01
        achievements(local0) = $00
    Next
    refineditems = $00
    consoleinput = ""
    consoleopen = $00
    eyeirritation = 0.0
    eyestuck = 0.0
    shouldplay = $00
    killtimer = 0.0
    falltimer = 0.0
    stamina = 100.0
    blurtimer = 0.0
    superman = $00
    supermantimer = 0.0
    sanity = 0.0
    restoresanity = $01
    crouch = $00
    crouchstate = 0.0
    lightvolume = 0.0
    vomit = $00
    vomittimer = 0.0
    secondarylighton = 1.0
    prevsecondarylighton = 1.0
    remotedooron = $01
    soundtransmission = $00
    chs\Field4 = $00
    i_447\Field0 = $00
    i_447\Field1 = -1.0
    i_447\Field2 = $00
    i_447\Field3 = -1.0
    i_447\Field4 = $00
    i_447\Field5 = -1.0
    usedmorphine = $00
    morphinetimer = 0.0
    morphinehealamount = 0.0
    i_409\Field0 = 0.0
    i_178\Field0 = $00
    i_215\Field0 = $00
    i_215\Field1 = 0.0
    i_215\Field2 = 0.0
    i_215\Field4 = $00
    i_1033ru\Field2 = $00
    i_1033ru\Field0 = $00
    i_1033ru\Field1 = $00
    i_1079\Field0 = 0.0
    i_1079\Field1 = $00
    i_1079\Field3 = $00
    i_1079\Field2 = $00
    i_207\Field0 = 0.0
    i_500\Field0 = $00
    i_402\Field1 = 0.0
    i_402\Field0 = $00
    i_357\Field0 = 0.0
    chancetospawn005 = rand($03, $01)
    mtf2timer = 0.0
    For local0 = $00 To $09 Step $01
        mtf2rooms[local0] = Null
        mtf2roomstate[local0] = $00
    Next
    contained457 = $00
    chs\Field3 = $00
    gasmaskblurtimer = 0.0
    For local13 = Each objects
        Delete local13
    Next
    curr650 = Null
    curr066 = Null
    For local0 = $00 To $06 Step $01
        mtf2rooms[local0] = Null
    Next
    chs\Field5 = $00
    wearinghelmet = $00
    msg = ""
    msgtimer = 0.0
    selecteditem = Null
    For local0 = $00 To (maxitemamount - $01) Step $01
        inventory(local0) = Null
    Next
    selecteditem = Null
    closestbutton = $00
    For local7 = Each doors
        Delete local7
    Next
    For local6 = Each lighttemplates
        Delete local6
    Next
    For local8 = Each materials
        Delete local8
    Next
    For local9 = Each waypoints
        Delete local9
    Next
    For local10 = Each tempwaypoints
        Delete local10
    Next
    For local11 = Each rooms
        Delete local11
    Next
    For local4 = Each itemtemplates
        Delete local4
    Next
    For local12 = Each items
        Delete local12
    Next
    For local14 = Each props
        Delete local14
    Next
    For local15 = Each decals
        Delete local15
    Next
    For local16 = Each npcs
        Delete local16
    Next
    curr173 = Null
    curr106 = Null
    curr096 = Null
    curr5131 = Null
    For local0 = $00 To $06 Step $01
        mtfrooms[local0] = Null
    Next
    forestnpc = $00
    local17 = $00
    For local18 = Each events
        If (local18\Field9 <> $00) Then
            freesound_strict(local18\Field9)
        EndIf
        If (local18\Field10 <> $00) Then
            freesound_strict(local18\Field10)
        EndIf
        If (local18\Field11 <> $00) Then
            freesound_strict(local18\Field11)
        EndIf
        Delete local18
    Next
    For local19 = Each securitycams
        Delete local19
    Next
    For local20 = Each emitters
        Delete local20
    Next
    For local21 = Each particles
        Delete local21
    Next
    For local22 = Each roomtemplates
        local22\Field0 = $00
    Next
    For local0 = $00 To $05 Step $01
        If (channelplaying(radiochn(local0)) <> 0) Then
            stopchannel(radiochn(local0))
        EndIf
    Next
    i_1499\Field1 = 0.0
    i_1499\Field2 = 0.0
    i_1499\Field3 = 0.0
    i_1499\Field4 = Null
    i_1499\Field5 = 0.0
    i_1499\Field6 = 0.0
    i_1499\Field7 = 0.0
    i_1499\Field0 = $00
    deletechunks()
    deleteelevatorobjects()
    deletedevilemitters()
    chs\Field2 = $00
    optionsmenu = $FFFFFFFF
    quitmsg = $FFFFFFFF
    achievementsmenu = $FFFFFFFF
    musicvolume = prevmusicvolume
    sfxvolume = prevsfxvolume
    deafplayer = $00
    deaftimer = 0.0
    i_008\Field1 = $00
    Delete Each achievementmsg
    currachvmsgid = $00
    clearworld($01, $01, $01)
    reloadaafont()
    camera = $00
    ark_blur_cam = $00
    collider = $00
    sky = $00
    initfastresize()
    If (local24 = $00) Then
        local23 = "lcz"
    ElseIf (local24 = $01) Then
        local23 = "hcz"
    Else
        Select rand($02, $01)
            Case $01
                local23 = "lcz"
            Case $02
                local23 = "hcz"
        End Select
    EndIf
    putinivalue("options.ini", "options", "game progress", local23)
    Return $00
End Function
