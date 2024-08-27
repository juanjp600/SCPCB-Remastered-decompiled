Function EntryPoint%()
    Local local0$
    Local local1$
    Local local2$
    Local local3$
    Local local4$
    Local local5$
    Local local6$
    Local local7$
    Local local8$
    Local local9%
    Local local10.fonts
    Local local12%
    Local local13%
    Local local14.fps_settings
    Local local15%
    Local local16$
    Local local17%
    Local local18%
    scpsdk_processcmdargs(commandline())
    scpsteam_initialize()
    scpdiscord_initialize()
    scpdiscord_update("", "1")
    scplang_setlang(getinistring("options.ini", "game", "lang", "1"))
    local0 = scpmodding_processfilepath("GFX\")
    local1 = scpmodding_processfilepath("SFX\")
    local2 = scpmodding_processfilepath("GFX\font\")
    local3 = scpmodding_processfilepath("GFX\map\")
    local4 = scpmodding_processfilepath("GFX\npcs\")
    local5 = scpmodding_processfilepath("SFX\Music\")
    local6 = scpmodding_processfilepath("SFX\Radio\UserTracks\")
    local7 = scpmodding_processfilepath("GFX\items\")
    local8 = ""
    If (filesize("fmod.dll") = $00) Then
        local8 = (((local8 + "fmod.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("FreeImage.dll") = $00) Then
        local8 = (((local8 + "FreeImage.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("dplayx.dll") = $00) Then
        local8 = (((local8 + "dplayx.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("BlitzMovie.dll") = $00) Then
        local8 = (((local8 + "BlitzMovie.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("d3dim.dll") = $00) Then
        local8 = (((local8 + "d3dim.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("d3dim700.dll") = $00) Then
        local8 = (((local8 + "d3dim700.dll") + chr($0D)) + chr($0A))
    EndIf
    If (filesize("steam_api.dll") = $00) Then
        local8 = (((local8 + "steam_api.dll") + chr($0D)) + chr($0A))
    EndIf
    If (len(local8) > $00) Then
        runtimeerror(((((("The following DLLs were not found in the game directory:" + chr($0D)) + chr($0A)) + chr($0D)) + chr($0A)) + local8))
    EndIf
    fsound_init($AC44, $40, $00)
    getdesktopsize()
    g_viewport_x = $00
    g_viewport_y = $00
    g_viewport_width = g_desktop_screen_width
    g_viewport_height = g_desktop_screen_height
    g_app_handle = (Int systemproperty("AppHWND"))
    If (windowed3d() = $00) Then
        runtimeerror("FATAL ERROR: Your computer does not support the rendering of 3D graphics within a window.")
    EndIf
    Dim keyname$($D3)
    keyname($01) = "Esc"
    For local9 = $02 To $0A Step $01
        keyname(local9) = (Str (local9 - $01))
    Next
    keyname($0B) = "0"
    keyname($0C) = "-"
    keyname($0D) = "="
    keyname($0E) = "Backspace"
    keyname($0F) = "TAB"
    keyname($10) = "Q"
    keyname($11) = "W"
    keyname($12) = "E"
    keyname($13) = "R"
    keyname($14) = "T"
    keyname($15) = "Y"
    keyname($16) = "U"
    keyname($17) = "I"
    keyname($18) = "O"
    keyname($19) = "P"
    keyname($1A) = "["
    keyname($1B) = "]"
    keyname($1C) = "Enter"
    keyname($1D) = "Left Ctrl"
    keyname($1E) = "A"
    keyname($1F) = "S"
    keyname($20) = "D"
    keyname($21) = "F"
    keyname($22) = "G"
    keyname($23) = "H"
    keyname($24) = "J"
    keyname($25) = "K"
    keyname($26) = "L"
    keyname($27) = ";"
    keyname($28) = "'"
    keyname($2A) = "Left Shift"
    keyname($2B) = "\"
    keyname($2C) = "Z"
    keyname($2D) = "X"
    keyname($2E) = "C"
    keyname($2F) = "V"
    keyname($30) = "B"
    keyname($31) = "N"
    keyname($32) = "M"
    keyname($33) = ","
    keyname($34) = "."
    keyname($36) = "Right Shift"
    keyname($38) = "Left Alt"
    keyname($39) = "Space"
    keyname($3A) = "Caps Lock"
    keyname($3B) = "F1"
    keyname($3C) = "F2"
    keyname($3D) = "F3"
    keyname($3E) = "F4"
    keyname($3F) = "F5"
    keyname($40) = "F6"
    keyname($41) = "F7"
    keyname($42) = "F8"
    keyname($43) = "F9"
    keyname($44) = "F10"
    keyname($9D) = "Right Control"
    keyname($B8) = "Right Alt"
    keyname($C8) = "Up"
    keyname($CB) = "Left"
    keyname($CD) = "Right"
    keyname($D0) = "Down"
    launcherwidth = (Int min((Float getiniint("options.ini", "launcher", "launcher width", $00)), 1024.0))
    launcherheight = (Int min((Float getiniint("options.ini", "launcher", "launcher height", $00)), 768.0))
    launcherenabled = getiniint("options.ini", "launcher", "launcher enabled", $00)
    bumpenabled = getiniint("options.ini", "graphics", "bump mapping enabled", $00)
    vsync = getiniint("options.ini", "graphics", "vsync", $00)
    opt_antialias = getiniint("options.ini", "graphics", "antialias", $00)
    enableroomlights = getiniint("options.ini", "graphics", "room lights enabled", $00)
    screengamma = getinifloat("options.ini", "graphics", "screengamma", 0.0)
    particleamount = getiniint("options.ini", "graphics", "particle amount", $00)
    texturedetails = getiniint("options.ini", "graphics", "texture details", $00)
    savetexturesinvram = getiniint("options.ini", "graphics", "enable vram", $00)
    fov = getinifloat("options.ini", "graphics", "fov", 0.0)
    musicvolume = getinifloat("options.ini", "audio", "music volume", 0.0)
    sfxvolume = getinifloat("options.ini", "audio", "sound volume", 0.0)
    enablesfxrelease = getiniint("options.ini", "audio", "sfx release", $00)
    enableusertracks = getiniint("options.ini", "audio", "enable user tracks", $00)
    usertrackmode = getiniint("options.ini", "audio", "user track setting", $00)
    mousesensitivity = getinifloat("options.ini", "controls", "mouse sensitivity", 0.0)
    invertmouse = getiniint("options.ini", "controls", "invert mouse y", $00)
    mousesmooth = getinifloat("options.ini", "controls", "mouse smoothing", 0.0)
    key_right = getiniint("options.ini", "controls", "Right key", $00)
    key_left = getiniint("options.ini", "controls", "Left key", $00)
    key_up = getiniint("options.ini", "controls", "Up key", $00)
    key_down = getiniint("options.ini", "controls", "Down key", $00)
    key_blink = getiniint("options.ini", "controls", "Blink key", $00)
    key_sprint = getiniint("options.ini", "controls", "Sprint key", $00)
    key_inv = getiniint("options.ini", "controls", "Inventory key", $00)
    key_crouch = getiniint("options.ini", "controls", "Crouch key", $00)
    key_save = getiniint("options.ini", "controls", "Save key", $00)
    key_console = getiniint("options.ini", "controls", "Console key", $00)
    key_screenshot = getiniint("options.ini", "controls", "Screenshot key", $00)
    hudenabled = getiniint("options.ini", "advanced", "HUD enabled", $00)
    canopenconsole = getiniint("options.ini", "advanced", "console enabled", $00)
    consoleopening = getiniint("options.ini", "advanced", "console auto opening", $00)
    consoleversion = getiniint("options.ini", "advanced", "console version", $00)
    achvmsgenabled = getiniint("options.ini", "advanced", "achievement popup enabled", $00)
    showfps = getiniint("options.ini", "advanced", "show FPS", $00)
    framelimit = getiniint("options.ini", "advanced", "framelimit", $00)
    aatextenable = getiniint("options.ini", "advanced", "antialiased text", $00)
    introenabled = getiniint("options.ini", "game", "intro enabled", $00)
    brightness = (Int getinifloat("options.ini", "game", "brightness", 0.0))
    camerafognear = getinifloat("options.ini", "game", "camera fog near", 0.0)
    camerafogfar = getinifloat("options.ini", "game", "camera fog far", 0.0)
    unlockthaumiel = getiniint("options.ini", "game", "th", $00)
    mapwidth = getiniint("options.ini", "game", "map size", $00)
    mapheight = getiniint("options.ini", "game", "map size", $00)
    fogr = getiniint("options.ini", "game", "fog r", $00)
    fogg = getiniint("options.ini", "game", "fog g", $00)
    fogb = getiniint("options.ini", "game", "fog b", $00)
    graphicwidth = getiniint("options.ini", "options", "width", $00)
    graphicheight = getiniint("options.ini", "options", "height", $00)
    fullscreen = getiniint("options.ini", "options", "fullscreen", $00)
    borderlesswindowed = getiniint("options.ini", "options", "borderless windowed", $00)
    selectedgfxdriver = (Int max((Float getiniint("options.ini", "options", "gfx driver", $00)), 1.0))
    bit16mode = getiniint("options.ini", "options", "16bit", $00)
    playstartup = getiniint("options.ini", "options", "play startup video", $00)
    modcompatiblenumber = "5.5.4.1"
    local10 = (New fonts)
    enablesfxrelease_prev = enablesfxrelease
    Dim arrowimg%($04)
    depth = $00
    totalgfxmodes = countgfxmodes3d()
    Dim gfxmodewidths%(totalgfxmodes)
    Dim gfxmodeheights%(totalgfxmodes)
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
    aatextenable_prev = aatextenable
    If (launcherenabled <> 0) Then
        aspectratioratio = 1.0
        updatelauncher()
        If (borderlesswindowed <> 0) Then
            graphics3dext(g_viewport_width, g_viewport_height, $00, $02)
            api_setwindowlong(g_app_handle, $FFFFFFF0, $80000000)
            api_setwindowpos(g_app_handle, $00, g_viewport_x, g_viewport_y, g_viewport_width, g_viewport_height, $40)
            realgraphicwidth = g_viewport_width
            realgraphicheight = g_viewport_height
            aspectratioratio = (((Float graphicwidth) / (Float graphicheight)) / ((Float realgraphicwidth) / (Float realgraphicheight)))
            fullscreen = $00
        Else
            aspectratioratio = 1.0
            realgraphicwidth = graphicwidth
            realgraphicheight = graphicheight
            If (fullscreen <> 0) Then
                graphics3dext(graphicwidth, graphicheight, (bit16mode Shl $04), $01)
            Else
                graphics3dext(graphicwidth, graphicheight, $00, $02)
            EndIf
        EndIf
    Else
        For local9 = $01 To totalgfxmodes Step $01
            local12 = $00
            For local13 = $00 To (totalgfxmodes - $01) Step $01
                If (((gfxmodewidths(local13) = gfxmodewidth(local9)) And (gfxmodeheights(local13) = gfxmodeheight(local9))) <> 0) Then
                    local12 = $01
                    Exit
                EndIf
            Next
            If (local12 = $00) Then
                If (((graphicwidth = gfxmodewidth(local9)) And (graphicheight = gfxmodeheight(local9))) <> 0) Then
                    selectedgfxmode = gfxmodes
                EndIf
                gfxmodewidths(gfxmodes) = gfxmodewidth(local9)
                gfxmodeheights(gfxmodes) = gfxmodeheight(local9)
                gfxmodes = (gfxmodes + $01)
            EndIf
        Next
        graphicwidth = gfxmodewidths(selectedgfxmode)
        graphicheight = gfxmodeheights(selectedgfxmode)
        If (borderlesswindowed <> 0) Then
            graphics3dext(g_viewport_width, g_viewport_height, $00, $02)
            api_setwindowlong(g_app_handle, $FFFFFFF0, $80000000)
            api_setwindowpos(g_app_handle, $00, g_viewport_x, g_viewport_y, g_viewport_width, g_viewport_height, $40)
            realgraphicwidth = g_viewport_width
            realgraphicheight = g_viewport_height
            aspectratioratio = (((Float graphicwidth) / (Float graphicheight)) / ((Float realgraphicwidth) / (Float realgraphicheight)))
            fullscreen = $00
        Else
            aspectratioratio = 1.0
            realgraphicwidth = graphicwidth
            realgraphicheight = graphicheight
            If (fullscreen <> 0) Then
                graphics3dext(graphicwidth, graphicheight, (bit16mode Shl $04), $01)
            Else
                graphics3dext(graphicwidth, graphicheight, $00, $02)
            EndIf
        EndIf
    EndIf
    menuscale = ((Float graphicheight) / 1024.0)
    setbuffer(backbuffer())
    local14 = (New fps_settings)
    currframelimit = ((Float (framelimit - $13)) / 100.0)
    seedrnd(millisecs())
    cansave = $01
    apptitle(("SCP: Containment Breach Remastered " + scpmodding_version()), "")
    playstartupvideos()
    cursorimg = loadimage_strict(scpmodding_processfilepath("GFX\cursor.png"))
    loadingback = loadimage_strict(scpmodding_processfilepath("LoadingScreens\loadingback.png"))
    initloadingscreens(scpmodding_processfilepath("LoadingScreens\loadingscreens.ini"))
    initaafont()
    local10\Field0[$00] = aaloadfont(scpmodding_processfilepath("GFX\font\cour\Courier New.ttf"), (Int (((Float graphicheight) / 1024.0) * 19.0)), $00, $00, $00, $02)
    local10\Field0[$01] = aaloadfont(scpmodding_processfilepath("GFX\font\courbd\Courier New.ttf"), (Int (((Float graphicheight) / 1024.0) * 58.0)), $00, $00, $00, $02)
    local10\Field0[$02] = aaloadfont(scpmodding_processfilepath("GFX\font\DS-DIGI\DS-Digital.ttf"), (Int (((Float graphicheight) / 1024.0) * 22.0)), $00, $00, $00, $02)
    local10\Field0[$03] = aaloadfont(scpmodding_processfilepath("GFX\font\DS-DIGI\DS-Digital.ttf"), (Int (((Float graphicheight) / 1024.0) * 58.0)), $00, $00, $00, $02)
    local10\Field0[$04] = aaloadfont(scpmodding_processfilepath("GFX\font\Journal\Journal.ttf"), (Int (((Float graphicheight) / 1024.0) * 58.0)), $00, $00, $00, $02)
    local10\Field1 = aaloadfont("Blitz", (Int (((Float graphicheight) / 1024.0) * 20.0)), $00, $00, $00, $01)
    aasetfont(local10\Field0[$01])
    blinkmeterimg = loadimage_strict(scpmodding_processfilepath("GFX\blinkmeter.png"))
    drawloading($00, $01)
    viewport_center_x = (graphicwidth Sar $01)
    viewport_center_y = (graphicheight Sar $01)
    mouselook_x_inc = 0.3
    mouselook_y_inc = 0.3
    mouse_left_limit = $FA
    mouse_right_limit = (graphicswidth() - $FA)
    mouse_top_limit = $96
    mouse_bottom_limit = (graphicsheight() - $96)
    mouse_smooth = getiniint("options.ini", "options", "mouse smoothing", $01)
    mouse_x_leverturn = 0.0
    mouse_y_leverturn = 0.0
    playable = $01
    staminaeffect = 1.0
    blinkeffect = 1.0
    chancetospawn005 = rand($03, $01)
    Dim achievements%($3B)
    Dim achievementstrings$($3B)
    Dim achievementdescs$($3B)
    Dim achvimg%($3B)
    For local9 = $00 To $3A Step $01
        local15 = getinisectionlocation(scpmodding_processfilepath("Data\achievementstrings.ini"), ("s" + (Str local9)))
        achievementstrings(local9) = scplang_getphrase(getinistring2(scpmodding_processfilepath("Data\achievementstrings.ini"), local15, "string1", ""))
        achievementdescs(local9) = scplang_getphrase(getinistring2(scpmodding_processfilepath("Data\achievementstrings.ini"), local15, "AchvDesc", ""))
        local16 = getinistring2(scpmodding_processfilepath("Data\achievementstrings.ini"), local15, "image", "")
        achvimg(local9) = loadimage_strict(scpmodding_processfilepath((("GFX\menu\achievements\" + local16) + ".png")))
        achvimg(local9) = resizeimage2(achvimg(local9), (Int ((Float (imagewidth(achvimg(local9)) * graphicheight)) / 768.0)), (Int ((Float (imageheight(achvimg(local9)) * graphicheight)) / 768.0)))
        bufferdirty(imagebuffer(achvimg(local9), $00))
    Next
    achvlocked = loadimage_strict(scpmodding_processfilepath("GFX\menu\achievements\AchvLocked.png"))
    achvlocked = resizeimage2(achvlocked, (Int ((Float (imagewidth(achvlocked) * graphicheight)) / 768.0)), (Int ((Float (imageheight(achvlocked) * graphicheight)) / 768.0)))
    bufferdirty(imagebuffer(achvlocked, $00))
    currachvmsgid = $00
    noclipspeed = 2.0
    chs = (New cheats)
    coffindistance = 100.0
    lightson = $01
    ms = (New menu_settings)
    otheropen = Null
    i_end = (New ending)
    Dim drawarrowicon%($04)
    Dim difficulties.difficulty($04)
    difficulties($00) = (New difficulty)
    difficulties($00)\Field10 = $01
    difficulties($00)\Field0 = scplang_getphrase("difficulty.safe")
    difficulties($00)\Field1 = scplang_getphrase("difficulty.safed")
    difficulties($00)\Field2 = $00
    difficulties($00)\Field3 = $00
    difficulties($00)\Field4 = $00
    difficulties($00)\Field5 = $00
    difficulties($00)\Field11 = $00
    difficulties($00)\Field6 = $78
    difficulties($00)\Field7 = $96
    difficulties($00)\Field8 = $32
    difficulties($01) = (New difficulty)
    difficulties($01)\Field10 = $01
    difficulties($01)\Field0 = scplang_getphrase("difficulty.euclid")
    difficulties($01)\Field1 = scplang_getphrase("difficulty.euclidd")
    difficulties($01)\Field2 = $00
    difficulties($01)\Field3 = $00
    difficulties($01)\Field4 = $02
    difficulties($01)\Field5 = $01
    difficulties($01)\Field11 = $00
    difficulties($01)\Field6 = $C8
    difficulties($01)\Field7 = $C8
    difficulties($01)\Field8 = $00
    difficulties($02) = (New difficulty)
    difficulties($02)\Field10 = $01
    difficulties($02)\Field0 = scplang_getphrase("difficulty.keter")
    difficulties($02)\Field1 = scplang_getphrase("difficulty.keterd")
    difficulties($02)\Field2 = $01
    difficulties($02)\Field3 = $01
    difficulties($02)\Field4 = $01
    difficulties($02)\Field5 = $02
    difficulties($02)\Field11 = $00
    difficulties($02)\Field6 = $C8
    difficulties($02)\Field7 = $00
    difficulties($02)\Field8 = $00
    difficulties($03) = (New difficulty)
    difficulties($03)\Field10 = $00
    difficulties($03)\Field0 = scplang_getphrase("difficulty.apollyon")
    difficulties($03)\Field1 = scplang_getphrase("difficulty.apollyond")
    difficulties($03)\Field2 = $01
    difficulties($03)\Field3 = $01
    difficulties($03)\Field4 = $01
    difficulties($03)\Field5 = $02
    difficulties($03)\Field11 = $01
    difficulties($03)\Field6 = $64
    difficulties($03)\Field7 = $64
    difficulties($03)\Field8 = $64
    difficulties($04) = (New difficulty)
    difficulties($04)\Field0 = scplang_getphrase("difficulty.custom")
    difficulties($04)\Field10 = $01
    difficulties($04)\Field2 = $00
    difficulties($04)\Field3 = $01
    difficulties($04)\Field4 = $00
    difficulties($04)\Field9 = $01
    difficulties($04)\Field5 = $00
    difficulties($04)\Field11 = $00
    difficulties($04)\Field6 = $FF
    difficulties($04)\Field7 = $FF
    difficulties($04)\Field8 = $FF
    selecteddifficulty = difficulties($00)
    Dim radiostate#($0A)
    Dim radiostate3%($0A)
    Dim radiostate4%($09)
    Dim radiochn%($08)
    consoleflushsnd = $00
    consolemusflush = $00
    consolemusplay = $00
    isnvgblinking = $00
    consolereissue = Null
    consoler = $FF
    consoleg = $FF
    consoleb = $FF
    storedcamerafogfar = camerafogfar
    tempsoundindex = $00
    Dim music$($22)
    music($00) = "The Dread"
    music($01) = "HeavyContainment"
    music($02) = "EntranceZone"
    music($03) = "PD"
    music($04) = "Room079"
    music($05) = "GateB1"
    music($06) = "GateB2"
    music($07) = "Room3Storage"
    music($08) = "Room049"
    music($09) = "Forest"
    music($0A) = "106Chase"
    music($0B) = "Menu"
    music($0C) = "860_2Chase"
    music($0D) = "Intro"
    music($0E) = "Using178"
    music($0F) = "PDTrench"
    music($10) = "Room205"
    music($11) = "GateA"
    music($12) = "Dimension1499"
    music($13) = "Dimension1499Danger"
    music($14) = "049Chase"
    music($15) = "..\Ending\MenuBreath"
    music($16) = "Room914"
    music($17) = "Ending"
    music($18) = "Credits"
    music($19) = "SaveMeFrom"
    music($1A) = "Room2Tunnel"
    music($1B) = "650Chase"
    music($1C) = "Room457"
    music($1D) = "Room409"
    music($1E) = "Using215"
    music($1F) = "Using1033RU"
    music($20) = "Room035"
    music($21) = "Room106"
    musicchn = streamsound_strict(scpmodding_processfilepath((("SFX\Music" + music($02)) + ".ogg")), musicvolume, $02)
    currmusicvolume = 1.0
    nowplaying = $02
    shouldplay = $0B
    currmusic = $01
    drawloading($0A, $01)
    Dim opendoorsfx%($03, $03)
    Dim closedoorsfx%($03, $03)
    Dim opendoorfastsfx%($01)
    Dim decaysfx%($05)
    drawloading($14, $01)
    Dim rustlesfx%($07)
    Dim dripsfx%($06)
    Dim radiosfx%($05, $0A)
    Dim picksfx%($0A)
    Dim ambientsfxamount%($06)
    ambientsfxamount($00) = $19
    ambientsfxamount($01) = $18
    ambientsfxamount($02) = $18
    ambientsfxamount($03) = $0F
    ambientsfxamount($04) = $05
    ambientsfxamount($05) = $0D
    Dim ambientsfx%($06, $5C)
    Dim oldmansfx%($09)
    Dim scp173sfx%($03)
    Dim horrorsfx%($15)
    drawloading($19, $01)
    Dim introsfx%($14)
    Dim alarmsfx%($06)
    Dim commotionstate%($1A)
    Dim breathsfx%($02, $05)
    Dim necksnapsfx%($03)
    Dim damagesfx%($09)
    Dim mtfsfx%($08)
    Dim coughsfx%($03)
    Dim stepsfx%($05, $02, $08)
    Dim step2sfx%($06)
    Dim nvguse%($01)
    Dim damagesfx1033ru%($03)
    Dim sizzsfx%($01)
    Dim mtf2sfx%($08)
    Dim scientistradiosfx%($01)
    Dim vehiclesfx%($01)
    drawloading($1E, $01)
    playcustommusic = $00
    custommusic = $00
    monitortimer = 0.0
    monitortimer2 = 0.0
    nvgimages = loadanimimage(scpmodding_processfilepath("GFX\battery.png"), $40, $40, $00, $02)
    maskimage(nvgimages, $FF, $00, $FF)
    usertrackcheck = $00
    usertrackcheck2 = $00
    usertrackmusicamount = $00
    usertrackflag = $00
    Dim usertrackname$($100)
    optionsmenu = $00
    quitmsg = $00
    infacility = $01
    prevmusicvolume = musicvolume
    prevsfxvolume = sfxvolume
    deafplayer = $00
    deaftimer = 0.0
    room2gw_brokendoor = $00
    room2gw_x = 0.0
    room2gw_z = 0.0
    menuroomscale = (1.0 / 256.0)
    currmenu_testimg = ""
    Dim navimages%($05)
    For local9 = $00 To $03 Step $01
        navimages(local9) = loadimage_strict(scpmodding_processfilepath((("GFX\items\navigator\room_border" + (Str local9)) + ".png")))
        maskimage(navimages(local9), $FF, $00, $FF)
    Next
    navimages($04) = loadimage_strict(scpmodding_processfilepath("GFX\items\navigator\battery_meter.png"))
    navbg = createimage(graphicwidth, graphicheight, $01)
    drawloading($23, $01)
    maxitemamount = $0A
    Dim inventory.items((maxitemamount + $01))
    hisssfx = loadsound_strict(scpmodding_processfilepath("SFX\General\Hiss.ogg"))
    smokedelay = $00
    drawloading($28, $01)
    loadroomtemplates(scpmodding_processfilepath("Data\rooms.ini"))
    roomscale = (1.0 / 256.0)
    Dim maptemp%((mapwidth + $01), (mapheight + $01))
    Dim mapfound%((mapwidth + $01), (mapheight + $01))
    hidedistance = 15.0
    secondarylighton = 1.0
    prevsecondarylighton = 1.0
    remotedooron = $01
    contained106 = $00
    contained457 = $00
    Dim mapf%((mapwidth + $01), (mapheight + $01))
    Dim mapg%((mapwidth + $01), (mapheight + $01))
    Dim maph%((mapwidth + $01), (mapheight + $01))
    Dim mapstate%((mapwidth + $01), (mapheight + $01))
    Dim mapparent%((mapwidth + $01), (mapheight + $01), $02)
    Dim mapname$(mapwidth, mapheight)
    Dim maproomid%($06)
    Dim maproom$($06, $00)
    updateroomlightstimer = 0.0
    Dim chunkdata%($40, $40)
    drawloading($50, $01)
    collisions($02, $01, $02, $02)
    collisions($02, $02, $01, $03)
    collisions($03, $01, $02, $02)
    collisions($04, $04, $01, $02)
    collisions($05, $01, $02, $02)
    collisions($05, $05, $01, $03)
    collisions($06, $01, $02, $02)
    drawloading($5A, $01)
    Dim lightspritetex%($05)
    unabletomove = $00
    shouldentitiesfall = $01
    playerfallingpickdistance = 10.0
    save_msg = ""
    save_msg_timer = $00
    save_msg_y = $00
    mtf_camerachecktimer = 0.0
    mtf_cameracheckdetected = $00
    at = (New alltextures)
    menuwhite = loadimage_strict(scpmodding_processfilepath("GFX\menu\menuwhite.png"))
    menublack = loadimage_strict(scpmodding_processfilepath("GFX\menu\menublack.png"))
    maskimage(menublack, $FF, $FF, $00)
    quickloadicon = loadimage_strict(scpmodding_processfilepath("GFX\menu\QuickLoading.png"))
    resizeimage(quickloadicon, ((Float imagewidth(quickloadicon)) * menuscale), ((Float imageheight(quickloadicon)) * menuscale))
    For local9 = $00 To $03 Step $01
        arrowimg(local9) = loadimage_strict(scpmodding_processfilepath("GFX\menu\arrow.png"))
        rotateimage(arrowimg(local9), (Float ($5A * local9)))
        handleimage(arrowimg(local9), $00, $00)
    Next
    ms\Field7[$00] = $01
    ms\Field7[$01] = $01
    Dim savegames$((savegameamount + $01))
    Dim savegametime$((savegameamount + $01))
    Dim savegamedate$((savegameamount + $01))
    Dim savegameversion$((savegameamount + $01))
    savedmapsamount = $00
    Dim savedmaps$((savedmapsamount + $01))
    Dim savedmapsauthor$((savedmapsamount + $01))
    loadsavegames()
    currloadgamepage = $00
    Dim menublinktimer%($02)
    Dim menublinkduration%($02)
    menublinktimer($00) = $01
    menublinktimer($01) = $01
    menuback = loadimage_strict(scpmodding_processfilepath("GFX\menu\back.png"))
    resizeimage(menuback, (((Float imagewidth(menuback)) * menuscale) * 0.75), (((Float imageheight(menuback)) * menuscale) * 0.75))
    quickloadpercent = $FFFFFFFF
    quickloadpercent_displaytimer = 0.0
    onsliderid = $00
    scrollbary = $00
    scrollmenuheight = $00
    ms\Field0 = $01
    m = (New memorystatus)
    flushkeys()
    flushmouse()
    drawloading($64, $01)
    local14\Field2 = millisecs()
    updateparticles_time = 0.0
    input_resettime = 0.0
    i_zone = (New mapzones)
    i_427 = (New scp427)
    i_215 = (New scp215)
    i_207 = (New scp207)
    i_402 = (New scp402)
    i_357 = (New scp357)
    i_1033ru = (New scp1033ru)
    i_1079 = (New scp1079)
    i_008 = (New scp008)
    i_409 = (New scp409)
    i_178 = (New scp178)
    i_1499 = (New scp1499)
    i_447 = (New scp447)
    i_714 = (New scp714)
    i_500 = (New scp500)
    Repeat
        If (keyhit(key_screenshot) <> 0) Then
            scpsdk_takescreenshot()
        EndIf
        cls()
        local14\Field0 = millisecs2()
        local14\Field8 = ((Float (local14\Field0 - local14\Field1)) / 1000.0)
        local14\Field1 = local14\Field0
        local14\Field4 = local14\Field3[$00]
        local14\Field3[$00] = max(min((local14\Field8 * 70.0), 5.0), 0.2)
        local14\Field3[$01] = local14\Field3[$00]
        If (((((((ms\Field1 Or invopen) Or (otheropen <> Null)) Or consoleopen) Or (selecteddoor <> Null)) Or (selectedscreen <> Null)) Or using294) <> 0) Then
            local14\Field3[$00] = 0.0
        EndIf
        If (framelimit > $00) Then
            local17 = (Int ((1000.0 / (Float framelimit)) - (Float (millisecs2() - local14\Field2))))
            delay(local17)
            local14\Field2 = millisecs2()
        EndIf
        If (local14\Field5 < millisecs2()) Then
            local14\Field7 = local14\Field6
            local14\Field6 = $00
            local14\Field5 = (millisecs2() + $3E8)
        EndIf
        local14\Field6 = (local14\Field6 + $01)
        If (0.0 >= input_resettime) Then
            doubleclick = $00
            mousehit1 = mousehit($01)
            If (mousehit1 <> 0) Then
                If ((millisecs2() - lastmousehit1) < $320) Then
                    doubleclick = $01
                EndIf
                lastmousehit1 = millisecs2()
            EndIf
            local18 = mousedown1
            mousedown1 = mousedown($01)
            If (((local18 = $01) And (mousedown1 = $00)) <> 0) Then
                mouseup1 = $01
            Else
                mouseup1 = $00
            EndIf
            mousehit2 = mousehit($02)
            If (((mousedown1 = $00) And (mousehit1 = $00)) <> 0) Then
                grabbedentity = $00
            EndIf
        Else
            input_resettime = max((input_resettime - local14\Field3[$00]), 0.0)
        EndIf
        updatemusic()
        If (enablesfxrelease <> 0) Then
            autoreleasesounds()
        EndIf
        If (ms\Field0 <> 0) Then
            If (shouldplay = $15) Then
                endbreathsfx = loadsound(scpmodding_processfilepath("SFX\Ending\MenuBreath.ogg"))
                endbreathchn = playsound(endbreathsfx)
                shouldplay = $42
            ElseIf (shouldplay = $42) Then
                If (channelplaying(endbreathchn) = $00) Then
                    freesound(endbreathsfx)
                    shouldplay = $0B
                EndIf
            Else
                shouldplay = $0B
            EndIf
            updatemainmenu()
            fpsmainmenu()
        Else
            mainloop()
        EndIf
        If (borderlesswindowed <> 0) Then
            If (((realgraphicwidth <> graphicwidth) Or (realgraphicheight <> graphicheight)) <> 0) Then
                setbuffer(texturebuffer(fresize_texture, $00))
                clscolor($00, $00, $00)
                cls()
                copyrect($00, $00, graphicwidth, graphicheight, ($400 - (graphicwidth Sar $01)), ($400 - (graphicheight Sar $01)), backbuffer(), texturebuffer(fresize_texture, $00))
                setbuffer(backbuffer())
                clscolor($00, $00, $00)
                cls()
                scalerender(0.0, 0.0, ((2050.0 / (Float graphicwidth)) * aspectratioratio), ((2050.0 / (Float graphicwidth)) * aspectratioratio))
            EndIf
        EndIf
        If (1.0 < screengamma) Then
            copyrect($00, $00, realgraphicwidth, realgraphicheight, ($400 - (realgraphicwidth Sar $01)), ($400 - (realgraphicheight Sar $01)), backbuffer(), texturebuffer(fresize_texture, $00))
            entityblend(fresize_image, $01)
            clscolor($00, $00, $00)
            cls()
            scalerender((-1.0 / (Float realgraphicwidth)), (1.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)))
            entityfx(fresize_image, $21)
            entityblend(fresize_image, $03)
            entityalpha(fresize_image, (screengamma - 1.0))
            scalerender((-1.0 / (Float realgraphicwidth)), (1.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)))
        ElseIf (1.0 > screengamma) Then
            copyrect($00, $00, realgraphicwidth, realgraphicheight, ($400 - (realgraphicwidth Sar $01)), ($400 - (realgraphicheight Sar $01)), backbuffer(), texturebuffer(fresize_texture, $00))
            entityblend(fresize_image, $01)
            clscolor($00, $00, $00)
            cls()
            scalerender((-1.0 / (Float realgraphicwidth)), (1.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)))
            entityfx(fresize_image, $21)
            entityblend(fresize_image, $02)
            entityalpha(fresize_image, 1.0)
            setbuffer(texturebuffer(fresize_texture2, $00))
            clscolor((Int (255.0 * screengamma)), (Int (255.0 * screengamma)), (Int (255.0 * screengamma)))
            cls()
            setbuffer(backbuffer())
            scalerender((-1.0 / (Float realgraphicwidth)), (1.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)))
            setbuffer(texturebuffer(fresize_texture2, $00))
            clscolor($00, $00, $00)
            cls()
            setbuffer(backbuffer())
        EndIf
        entityfx(fresize_image, $01)
        entityblend(fresize_image, $01)
        entityalpha(fresize_image, 1.0)
        If (vsync = $00) Then
            flip($00)
        Else
            flip($01)
        EndIf
    Forever
    creditstimer = 0.0
End Function
