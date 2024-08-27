Function updateconsole%()
    Local local0.fonts
    Local local1.events
    Local local2.consolemsg
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7$
    Local local8%
    Local local9%
    Local local10.events
    Local local11.rooms
    Local local12.items
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18%
    Local local19$
    Local local22%
    Local local23%
    Local local24%
    Local local25%
    Local local26$
    Local local28.itemtemplates
    Local local30.npcs
    Local local31%
    Local local32%
    Local local36.sound
    Local local37$
    Local local38$
    Local local40.events
    Local local43$
    Local local45$
    Local local46%
    Local local48%
    Local local49%
    Local local51%
    Local local52%
    local0 = (First fonts)
    If (canopenconsole = $00) Then
        consoleopen = $00
        Return $00
    EndIf
    If (selecteddifficulty\Field10 = $00) Then
        hudenabled = $00
        canopenconsole = $00
        consoleopening = $00
        achvmsgenabled = $00
        screengamma = 0.9
        fov = 74.0
        camerafognear = 0.35
        camerafogfar = 4.5
        Return $00
    EndIf
    If (consoleopen <> 0) Then
        aasetfont(local0\Field1)
        consoler = $FF
        consoleg = $FF
        consoleb = $FF
        If (consoleversion = $01) Then
            local3 = $00
            local4 = (Int ((Float graphicheight) - (300.0 * menuscale)))
            local5 = graphicwidth
            local6 = (Int ((300.0 * menuscale) - (30.0 * menuscale)))
        Else
            local3 = $14
            local4 = $28
            local5 = $190
            local6 = $1F4
        EndIf
        drawframe(local3, local4, local5, (Int ((30.0 * menuscale) + (Float local6))), $00, $00)
        local13 = $00
        local14 = $00
        For local2 = Each consolemsg
            local13 = (Int ((15.0 * menuscale) + (Float local13)))
        Next
        local14 = (Int (((Float local6) / (Float local13)) * (Float local6)))
        If (local14 > local6) Then
            local14 = local6
        EndIf
        If (local13 < local6) Then
            local13 = local6
        EndIf
        color($32, $32, $32)
        local15 = mouseon((Int ((Float (local3 + local5)) - (26.0 * menuscale))), local4, (Int (26.0 * menuscale)), local6)
        If (local15 <> 0) Then
            color($46, $46, $46)
        EndIf
        rect((Int ((Float (local3 + local5)) - (26.0 * menuscale))), local4, (Int (26.0 * menuscale)), local6, $01)
        color($78, $78, $78)
        local16 = mouseon((Int ((Float (local3 + local5)) - (23.0 * menuscale))), (Int (((consolescroll * (Float local14)) / (Float local6)) + (Float ((local4 + local6) - local14)))), (Int (20.0 * menuscale)), local14)
        If (local16 <> 0) Then
            color($C8, $C8, $C8)
        EndIf
        If (consolescrolldragging <> 0) Then
            color($FF, $FF, $FF)
        EndIf
        rect((Int ((Float (local3 + local5)) - (23.0 * menuscale))), (Int (((consolescroll * (Float local14)) / (Float local6)) + (Float ((local4 + local6) - local14)))), (Int (20.0 * menuscale)), local14, $01)
        If (mousedown($01) = $00) Then
            consolescrolldragging = $00
        ElseIf (consolescrolldragging <> 0) Then
            consolescroll = ((Float (((scaledmousey() - consolemousemem) * local6) / local14)) + consolescroll)
            consolemousemem = scaledmousey()
        EndIf
        If (consolescrolldragging = $00) Then
            If (mousehit1 <> 0) Then
                If (local16 <> 0) Then
                    consolescrolldragging = $01
                    consolemousemem = scaledmousey()
                ElseIf (local15 <> 0) Then
                    consolescroll = ((Float ((((scaledmousey() - (local4 + local6)) * local13) / local6) + (local6 Sar $01))) + consolescroll)
                    consolescroll = (consolescroll / 2.0)
                EndIf
            EndIf
        EndIf
        local17 = mousezspeed()
        If (local17 = $01) Then
            consolescroll = (consolescroll - (15.0 * menuscale))
        ElseIf (local17 = $FFFFFFFF) Then
            consolescroll = ((15.0 * menuscale) + consolescroll)
        EndIf
        If (keyhit($C8) <> 0) Then
            local18 = $00
            If (consolereissue = Null) Then
                consolereissue = (First consolemsg)
                While (consolereissue <> Null)
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local18 = (Int ((Float local18) - (15.0 * menuscale)))
                    consolereissue = (After consolereissue)
                Wend
            Else
                local2 = (First consolemsg)
                While (local2 <> Null)
                    If (local2 = consolereissue) Then
                        Exit
                    EndIf
                    local18 = (Int ((Float local18) - (15.0 * menuscale)))
                    local2 = (After local2)
                Wend
                consolereissue = (After consolereissue)
                local18 = (Int ((Float local18) - (15.0 * menuscale)))
                Repeat
                    If (consolereissue = Null) Then
                        consolereissue = (First consolemsg)
                        local18 = $00
                    EndIf
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local18 = (Int ((Float local18) - (15.0 * menuscale)))
                    consolereissue = (After consolereissue)
                Forever
            EndIf
            If (consolereissue <> Null) Then
                consoleinput = consolereissue\Field0
                consolescroll = (Float ((local6 Sar $01) + local18))
            EndIf
        EndIf
        If (keyhit($D0) <> 0) Then
            local18 = (Int ((15.0 * menuscale) + (Float (- local13))))
            If (consolereissue = Null) Then
                consolereissue = (Last consolemsg)
                While (consolereissue <> Null)
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local18 = (Int ((15.0 * menuscale) + (Float local18)))
                    consolereissue = (Before consolereissue)
                Wend
            Else
                local2 = (Last consolemsg)
                While (local2 <> Null)
                    If (local2 = consolereissue) Then
                        Exit
                    EndIf
                    local18 = (Int ((15.0 * menuscale) + (Float local18)))
                    local2 = (Before local2)
                Wend
                consolereissue = (Before consolereissue)
                local18 = (Int ((15.0 * menuscale) + (Float local18)))
                Repeat
                    If (consolereissue = Null) Then
                        consolereissue = (Last consolemsg)
                        local18 = (Int ((15.0 * menuscale) + (Float (- local13))))
                    EndIf
                    If (consolereissue\Field1 <> 0) Then
                        Exit
                    EndIf
                    local18 = (Int ((15.0 * menuscale) + (Float local18)))
                    consolereissue = (Before consolereissue)
                Forever
            EndIf
            If (consolereissue <> Null) Then
                consoleinput = consolereissue\Field0
                consolescroll = (Float ((local6 Sar $01) + local18))
            EndIf
        EndIf
        If ((Float ((- local13) + local6)) > consolescroll) Then
            consolescroll = (Float ((- local13) + local6))
        EndIf
        If (0.0 < consolescroll) Then
            consolescroll = 0.0
        EndIf
        color($FF, $FF, $FF)
        selectedinputbox = $02
        local19 = consoleinput
        consoleinput = inputbox(local3, (local4 + local6), local5, (Int (30.0 * menuscale)), consoleinput, $02)
        If (local19 <> consoleinput) Then
            consolereissue = Null
        EndIf
        consoleinput = left(consoleinput, $64)
        If ((keyhit($1C) And (consoleinput <> "")) <> 0) Then
            consolereissue = Null
            consolescroll = 0.0
            createconsolemsg(consoleinput, $FF, $FF, $00, $01)
            If (instr(consoleinput, " ", $01) > $00) Then
                local7 = lower(left(consoleinput, (instr(consoleinput, " ", $01) - $01)))
            Else
                local7 = lower(consoleinput)
            EndIf
            Select lower(local7)
                Case "help"
                    If (instr(consoleinput, " ", $01) <> $00) Then
                        local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Else
                        local7 = ""
                    EndIf
                    consoler = $00
                    consoleg = $FF
                    consoleb = $FF
                    Select lower(local7)
                        Case "1",""
                            createconsolemsg("LIST OF COMMANDS - PAGE 1/3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- asd", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- status", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- camerapick", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- ending", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- noclipspeed", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- noclip", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- injure [value]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- infect [value]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- heal", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- teleport [room name]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- rooms", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- npcs", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- spawnitem [item name]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- wireframe", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- 173speed", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- 106speed", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- 173state", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- 106state", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg((((("Use " + chr($22)) + "help 2/3") + chr($22)) + " to find more commands."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg((((("Use " + chr($22)) + "help [command name]") + chr($22)) + " to get more information about a command."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "2"
                            createconsolemsg("LIST OF COMMANDS - PAGE 2/3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- spawn [npc type] [state]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- reset096", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- disable173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- enable173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- disable106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- enable106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- halloween", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- sanic", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- scp-420-j", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- godmode", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- revive", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- showfps", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- 096state", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- debughud", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- camerafog [near] [far]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- gamma [value]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- infinitestamina", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- playmusic [clip + .wav/.ogg]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- notarget", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- unlockexits", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- disablenuke", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg((((("Use " + chr($22)) + "help [command name]") + chr($22)) + " to get more information about a command."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "3"
                            createconsolemsg("LIST OF COMMANDS - PAGE 3/3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("MODS COMMANDS", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- newyear", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- cheats", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- fov [value]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- reset372", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- reset650", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- reset1033ru", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- money", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- crystal [value]", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- unlockachievements", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- disable049", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- enable049", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- enablecontrol", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- disablecontrol", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- unlockcheckpoints", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- disable966", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- enable966", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("- noblinking", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "asd"
                            createconsolemsg("HELP - asd", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Actives godmode, noclip, wireframe and", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("sets fog distance to 20 near, 30 far", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "rooms"
                            createconsolemsg("HELP - rooms", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Sends a list of all room IDs", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "npcs"
                            createconsolemsg("HELP - npcs", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Sends a list of all npc IDs", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "camerafog"
                            createconsolemsg("HELP - camerafog", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Sets the draw distance of the fog.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("The fog begins generating at 'CameraFogNear' units", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("away from the camera and becomes completely opaque", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("at 'CameraFogFar' units away from the camera.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Example: camerafog 20 40", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "gamma"
                            createconsolemsg("HELP - gamma", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Sets the gamma correction.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Should be set to a value between 0.0 and 2.0.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Default is 1.0.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "noclip","fly"
                            createconsolemsg("HELP - noclip", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Toggles noclip, unless a valid parameter", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("is specified (on/off).", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Allows the camera to move in any direction while", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("bypassing collision.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "godmode","god"
                            createconsolemsg("HELP - godmode", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Toggles godmode, unless a valid parameter", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("is specified (on/off).", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Prevents player death under normal circumstances.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "wireframe"
                            createconsolemsg("HELP - wireframe", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Toggles wireframe, unless a valid parameter", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("is specified (on/off).", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Allows only the edges of geometry to be rendered,", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("making everything else transparent.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "spawnitem"
                            createconsolemsg("HELP - spawnitem", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Spawns an item at the player's location.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Any name that can appear in your inventory", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("is a valid parameter.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Example: spawnitem Key Card Omni", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "spawn"
                            createconsolemsg("HELP - spawn", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Spawns an NPC at the player's location.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Valid parameters are:", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("008zombie / 049 / 049-2 / 066 / 096 / 106 / 173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("/ 178-1 / 372 / 513-1 / 966 / 1499-1 / class-d", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("/ guard / mtf / apache / tentacle / 939 / 008-2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("/ 049-3 / 650 / ci / mtf2 / 0081 / 457 / vehicle", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "revive","undead","resurrect"
                            createconsolemsg("HELP - revive", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Resets the player's death timer after the dying", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("animation triggers.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Does not affect injury, blood loss,", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("008 infection values", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("or 409 crystalization values and others.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "teleport"
                            createconsolemsg("HELP - teleport", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Teleports the player to the first instance", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("of the specified room. Any room that appears", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("in rooms.ini is a valid parameter.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "stopsound","stfu"
                            createconsolemsg("HELP - stopsound", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Stops all currently playing sounds.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Also skips the intro scene (after breach)", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "camerapick"
                            createconsolemsg("HELP - camerapick", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Prints the texture name and coordinates of", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("the model the camera is pointing at.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "status"
                            createconsolemsg("HELP - status", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Prints player, camera, and others.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "weed","scp-420-j","420j"
                            createconsolemsg("HELP - 420j", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Generates dank memes.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "playmusic"
                            createconsolemsg("HELP - playmusic", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Will play tracks in .ogg/.wav format", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg((((((("from " + chr($22)) + "SFX\") + "Music\") + "Custom\") + chr($22)) + "."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "disable106"
                            createconsolemsg("HELP - disable106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Removes SCP-106 from the map.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "enable106"
                            createconsolemsg("HELP - enable106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Returns SCP-106 to the map.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "disable173"
                            createconsolemsg("HELP - disable173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Removes SCP-173 from the map.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "enable173"
                            createconsolemsg("HELP - enable173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Returns SCP-173 to the map.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "reset096"
                            createconsolemsg("HELP - reset096", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Returns SCP-096 to idle state.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "newyear"
                            createconsolemsg("HELP - newyear", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Makes SCP-173 a cookie.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "cheats"
                            createconsolemsg("HELP - cheats", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Actives godmode, noclip, notarget", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("and infinitestamina.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Is specified (on/off).", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "fov"
                            createconsolemsg("HELP - fov", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Field of view (FOV) is the amount of game view", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("that is on display during a game.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "reset372"
                            createconsolemsg("HELP - reset372", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Returns SCP-372 to inactive state.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "reset650"
                            createconsolemsg("HELP - reset650", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Returns SCP-650 to inactive state.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "money"
                            createconsolemsg("HELP - money", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Generates a lot of money.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "crystal"
                            createconsolemsg("HELP - crystal", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("SCP-409 crystallizes player.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Example: crystal 52", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "reset1033ru"
                            createconsolemsg("HELP - reset1033ru", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Reset states of SCP-1033-RU.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "enablecontrol"
                            createconsolemsg("HELP - enablecontrol", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Remote door control on.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "disablecontrol"
                            createconsolemsg("HELP - disablecontrol", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Remote door control off.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "unlockcheckpoints"
                            createconsolemsg("HELP - unlockcheckpoints", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Unlocks all checkpoints.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "disable049"
                            createconsolemsg("HELP - disable049", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Removes SCP-049 from the map.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "enable049"
                            createconsolemsg("HELP - enable049", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Returns SCP-049 to the map.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "disable966"
                            createconsolemsg("HELP - disable966", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Removes SCP-966 from the map.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "enable966"
                            createconsolemsg("HELP - enable966", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("Returns SCP-966 to the map.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Default
                            createconsolemsg("There is no help available for that command.", $FF, $96, $00, $00)
                    End Select
                Case "asd"
                    wireframe($01)
                    wireframestate = $01
                    chs\Field0 = $01
                    chs\Field1 = $01
                    camerafognear = 15.0
                    camerafogfar = 20.0
                Case "status"
                    consoler = $00
                    consoleg = $FF
                    consoleb = $00
                    createconsolemsg("*******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Status: ", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Coordinates: ", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(((((("    - collider: " + (Str entityx(collider, $00))) + ", ") + (Str entityy(collider, $00))) + ", ") + (Str entityz(collider, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(((((("    - camera: " + (Str entityx(camera, $00))) + ", ") + (Str entityy(camera, $00))) + ", ") + (Str entityz(camera, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Rotation: ", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(((((("    - collider: " + (Str entitypitch(collider, $00))) + ", ") + (Str entityyaw(collider, $00))) + ", ") + (Str entityroll(collider, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(((((("    - camera: " + (Str entitypitch(camera, $00))) + ", ") + (Str entityyaw(camera, $00))) + ", ") + (Str entityroll(camera, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Room: " + playerroom\Field7\Field10), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    For local10 = Each events
                        If (local10\Field1 = playerroom) Then
                            createconsolemsg(("Room event: " + local10\Field0), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg(("-    state: " + (Str local10\Field2)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg(("-    state2: " + (Str local10\Field3)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg(("-    state3: " + (Str local10\Field4)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg(("-    state4: " + (Str local10\Field5)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            Exit
                        EndIf
                    Next
                    createconsolemsg(((("Room coordinates: " + (Str floor(((entityx(playerroom\Field2, $00) / 8.0) + 0.5)))) + ", ") + (Str floor(((entityz(playerroom\Field2, $00) / 8.0) + 0.5)))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Stamina: " + (Str stamina)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Death timer: " + (Str killtimer)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Blinktimer: " + (Str blinktimer)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Injuries: " + (Str injuries)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Blood Loss: " + (Str bloodloss)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Vomit Timer: " + (Str vomittimer)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Blur Timer: " + (Str blurtimer)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Light Blink: " + (Str lightblink)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Light Flash: " + (Str lightflash)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Sanity: " + (Str sanity)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Blink Effect Timer: " + (Str blinkeffecttimer)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Stamina Effect Timer: " + (Str staminaeffecttimer)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("MTF Timer: " + (Str mtftimer)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("SCP-008 Infection: " + (Str i_008\Field0)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("SCP-427 State (secs): " + (Str (Int (i_427\Field1 / 70.0)))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    For local9 = $00 To $05 Step $01
                        createconsolemsg(((("SCP-1025 State " + (Str local9)) + ": ") + (Str scp1025state[local9])), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Next
                    createconsolemsg("********** MOD STATS **********", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("BubbleFoam: " + (Str i_1079\Field0)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("BubbleTrigger: " + (Str i_1079\Field1)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("MTF2 Timer: " + (Str mtf2timer)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("SCP-409 Crystallization: " + (Str i_409\Field0)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("SCP-215 Idle State: " + (Str i_215\Field2)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("SCP-215 State: " + (Str i_215\Field1)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("SCP-207 State: " + (Str i_207\Field0)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("SCP-402 State: " + (Str i_402\Field1)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("SCP-357 State: " + (Str i_357\Field0)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    If (i_1033ru\Field2 = $01) Then
                        createconsolemsg((("HP of SCP-1033-RU: " + (Str i_1033ru\Field0)) + "/100"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        createconsolemsg((("Lost HP of SCP-1033-RU: " + (Str i_1033ru\Field1)) + "/100"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    ElseIf (i_1033ru\Field2 = $02) Then
                        createconsolemsg((("HP of SCP-1033-RU: " + (Str i_1033ru\Field0)) + "/200"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        createconsolemsg((("Lost HP of SCP-1033-RU: " + (Str i_1033ru\Field1)) + "/200"), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    EndIf
                    createconsolemsg("*******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "camerapick"
                    consoler = $00
                    consoleg = $FF
                    consoleb = $00
                    local22 = camerapick(camera, (Float (graphicwidth Sar $01)), (Float (graphicheight Sar $01)))
                    If (local22 = $00) Then
                        createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        createconsolemsg("No entity  picked", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        createconsolemsg("Picked entity:", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        local23 = getsurface(local22, $01)
                        local24 = getsurfacebrush(local23)
                        local25 = getbrushtexture(local24, $00)
                        local26 = strippath(texturename(local25))
                        createconsolemsg(("Texture name: " + local26), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        createconsolemsg(((((("Coordinates: " + (Str entityx(local22, $00))) + ", ") + (Str entityy(local22, $00))) + ", ") + (Str entityz(local22, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        createconsolemsg("******************************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    EndIf
                Case "hidedistance"
                    hidedistance = (Float right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    createconsolemsg(("Hidedistance set to " + (Str hidedistance)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "ending"
                    i_end\Field2 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    killtimer = -0.1
                Case "noclipspeed"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    noclipspeed = (Float local7)
                Case "injure"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    injuries = (Float local7)
                Case "infect"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    i_008\Field0 = (Float local7)
                Case "heal"
                    injuries = 0.0
                    bloodloss = 0.0
                    i_008\Field0 = 0.0
                    lightflash = 0.0
                    lightblink = 0.0
                    stamina = 100.0
                    blurtimer = 0.0
                    i_427\Field1 = 0.0
                    i_409\Field0 = 0.0
                    i_1079\Field0 = 0.0
                    i_1079\Field1 = $00
                    i_207\Field0 = 0.0
                    i_402\Field1 = 0.0
                    i_357\Field0 = 0.0
                    i_215\Field1 = 0.0
                    i_215\Field2 = 0.0
                    gasmaskblurtimer = 0.0
                    i_447\Field1 = -1.0
                    i_447\Field3 = -1.0
                    If (1.0 < staminaeffect) Then
                        staminaeffect = 1.0
                        staminaeffecttimer = 0.0
                    EndIf
                    If (1.0 < blinkeffect) Then
                        blinkeffect = 1.0
                        blinkeffecttimer = 0.0
                    EndIf
                    For local1 = Each events
                        If (local1\Field0 = "room009") Then
                            local1\Field2 = 0.0
                            local1\Field4 = 0.0
                        EndIf
                    Next
                    For local9 = $00 To $05 Step $01
                        scp1025state[local9] = 0.0
                    Next
                Case "teleport"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local7
                        Case "895","scp-895"
                            local7 = "room895"
                        Case "scp-914"
                            local7 = "room914"
                        Case "offices","office"
                            local7 = "room2offices"
                    End Select
                    For local11 = Each rooms
                        If (local11\Field7\Field10 = local7) Then
                            positionentity(collider, entityx(local11\Field2, $00), (entityy(local11\Field2, $00) + 0.7), entityz(local11\Field2, $00), $00)
                            resetentity(collider)
                            updatedoors()
                            updaterooms()
                            For local12 = Each items
                                local12\Field12 = 0.0
                            Next
                            playerroom = local11
                            Exit
                        EndIf
                    Next
                    If (playerroom\Field7\Field10 <> local7) Then
                        createconsolemsg("Room not found.", $FF, $96, $00, $00)
                    EndIf
                Case "rooms"
                    createconsolemsg("ROOMS LIST", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("*************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("dimension1499", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("pocketdimension", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room173intro", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("endroom", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room1archive", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room005", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room205", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room372", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room914", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("medibay2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2closets", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2_2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2_3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2_4", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2_5", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2doors", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2elevator", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2gw", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2gw_b", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2posters", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2scps", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2scps2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2scps3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2sl", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2storage", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2tesla_lcz", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2testroom2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room012", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room447", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room1123", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("lockroom", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("lockroom3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2C", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2C2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room066", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room1162", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room3_2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room3_3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room3scps", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room3storage", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room4", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room4_2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room4info", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("checkpoint1", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("endroom2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room035", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room079", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room096", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room895", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("tunnel", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("tunnel2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2catwalk", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2nuke", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2pipes", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2pipes2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2pit", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2servers", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2shaft", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2tesla_hcz", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2testroom", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2tunnel", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room008", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room049", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room409", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room457", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2Cpit", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2Ctunnel", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room650", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room3pit", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room3tunnel", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room3z2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room009", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room513", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room966", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room4pit", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room4tunnels", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("checkpoint2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("endroom3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("gatea", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("gateaentrance", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("gateb", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room1office", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room1lifts", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("medibay", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2bio", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2cafeteria", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2offices", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2offices2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2offices3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2offices4", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2offices5", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2poffices", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2poffices2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2servers2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2sroom", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2tesla", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2toilets", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2z3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2z3_2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room860", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("lockroom2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2Ccont", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2Coffices", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room2Cz3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room3servers", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room3servers2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room3offices", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room3offices2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room3z3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("room4z3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "npcs"
                    createconsolemsg("NPCS LIST", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("*************", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-096", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-049", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-049-2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("Guard", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("MTF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-860-2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-939", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-066", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-966", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-1499-1", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-650", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-457", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("MTF2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-008-2", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg("SCP-049-3", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "spawnitem"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    local8 = $00
                    For local28 = Each itemtemplates
                        If (lower(local28\Field0) = local7) Then
                            local8 = $01
                            createconsolemsg((local28\Field0 + " spawned."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            local12 = createitem(local28\Field0, local28\Field1, entityx(collider, $00), entityy(camera, $01), entityz(collider, $00), $00, $00, $00, 1.0, $00)
                            entitytype(local12\Field1, $03, $00)
                            Exit
                        ElseIf (lower(local28\Field1) = local7) Then
                            local8 = $01
                            createconsolemsg((local28\Field0 + " spawned."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            local12 = createitem(local28\Field0, local28\Field1, entityx(collider, $00), entityy(camera, $01), entityz(collider, $00), $00, $00, $00, 1.0, $00)
                            entitytype(local12\Field1, $03, $00)
                            Exit
                        EndIf
                    Next
                    If (local8 = $00) Then
                        createconsolemsg("Item not found.", $FF, $96, $00, $00)
                    EndIf
                Case "wireframe"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local7
                        Case "on","1","true"
                            wireframestate = $01
                        Case "off","0","false"
                            wireframestate = $00
                        Default
                            wireframestate = (wireframestate = $00)
                    End Select
                    If (wireframestate <> 0) Then
                        createconsolemsg("WIREFRAME ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        createconsolemsg("WIREFRAME OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    EndIf
                    wireframe(wireframestate)
                Case "173speed"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    curr173\Field21 = (Float local7)
                    createconsolemsg(("173's speed set to " + local7), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "106speed"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    curr106\Field21 = (Float local7)
                    createconsolemsg(("106's speed set to " + local7), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "173state"
                    createconsolemsg("SCP-173", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(((((("Position: " + (Str entityx(curr173\Field0, $00))) + ", ") + (Str entityy(curr173\Field0, $00))) + ", ") + (Str entityz(curr173\Field0, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Idle: " + (Str curr173\Field24)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("State: " + (Str curr173\Field9)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "106state"
                    createconsolemsg("SCP-106", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(((((("Position: " + (Str entityx(curr106\Field0, $00))) + ", ") + (Str entityy(curr106\Field0, $00))) + ", ") + (Str entityz(curr106\Field0, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("Idle: " + (Str curr106\Field24)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    createconsolemsg(("State: " + (Str curr106\Field9)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "reset096"
                    For local30 = Each npcs
                        If (local30\Field5 = $06) Then
                            local30\Field9 = 0.0
                            stopstream_strict(local30\Field17)
                            local30\Field17 = $00
                            If (local30\Field20 <> $00) Then
                                stopstream_strict(local30\Field20)
                                local30\Field20 = $00
                            EndIf
                            Exit
                        EndIf
                    Next
                Case "disable173"
                    curr173\Field24 = 3.0
                    hideentity(curr173\Field0)
                    hideentity(curr173\Field4)
                Case "enable173"
                    curr173\Field24 = 0.0
                    showentity(curr173\Field0)
                    showentity(curr173\Field4)
                Case "disable106"
                    curr106\Field24 = 1.0
                    curr106\Field9 = 200000.0
                    contained106 = $01
                Case "enable106"
                    curr106\Field24 = 0.0
                    contained106 = $00
                    showentity(curr106\Field4)
                    showentity(curr106\Field0)
                Case "halloween"
                    at\Field1[$00] = (at\Field1[$00] = $00)
                    If (at\Field1[$00] <> 0) Then
                        local31 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\scp_173_h.pt"), $01)
                        entitytexture(curr173\Field0, local31, $00, $00)
                        freetexture(local31)
                        createconsolemsg("173 JACK-O-LANTERN ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        local32 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\scp_173.png"), $01)
                        entitytexture(curr173\Field0, local32, $00, $00)
                        freetexture(local32)
                        createconsolemsg("173 JACK-O-LANTERN OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    EndIf
                Case "sanic"
                    superman = (superman = $00)
                    If (superman = $01) Then
                        createconsolemsg("GOTTA GO FAST", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        createconsolemsg("WHOA SLOW DOWN", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    EndIf
                Case "scp-420-j","420j","weed"
                    For local9 = $01 To $14 Step $01
                        If (rand($02, $01) = $01) Then
                            local12 = createitem("Some SCP-420-J", "scp420j", ((cos((18.0 * (Float local9))) * rnd(0.3, 0.5)) + entityx(collider, $01)), entityy(camera, $01), ((sin((18.0 * (Float local9))) * rnd(0.3, 0.5)) + entityz(collider, $01)), $00, $00, $00, 1.0, $00)
                        Else
                            local12 = createitem("Joint", "scp420s", ((cos((18.0 * (Float local9))) * rnd(0.3, 0.5)) + entityx(collider, $01)), entityy(camera, $01), ((sin((18.0 * (Float local9))) * rnd(0.3, 0.5)) + entityz(collider, $01)), $00, $00, $00, 1.0, $00)
                        EndIf
                        entitytype(local12\Field1, $03, $00)
                    Next
                    playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\Music\Using420J.ogg")))
                Case "godmode","god"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local7
                        Case "on","1","true"
                            chs\Field0 = $01
                        Case "off","0","false"
                            chs\Field0 = $00
                        Default
                            chs\Field0 = (chs\Field0 = $00)
                    End Select
                    If (chs\Field0 <> 0) Then
                        createconsolemsg("GODMODE ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        createconsolemsg("GODMODE OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    EndIf
                Case "revive","undead","resurrect"
                    dropspeed = -0.1
                    headdropspeed = 0.0
                    shake = 0.0
                    currspeed = 0.0
                    heartbeatvolume = 0.0
                    camerashake = 0.0
                    shake = 0.0
                    lightflash = 0.0
                    blurtimer = 0.0
                    i_427\Field1 = 0.0
                    i_008\Field0 = 0.0
                    i_1079\Field0 = 0.0
                    i_1079\Field1 = $00
                    bloodloss = 0.0
                    injuries = 0.0
                    i_207\Field0 = 0.0
                    i_402\Field1 = 0.0
                    i_357\Field0 = 0.0
                    falltimer = 0.0
                    ms\Field1 = $00
                    chs\Field0 = $00
                    chs\Field1 = $00
                    chs\Field3 = $00
                    resetentity(collider)
                    positionentity(collider, entityx(collider, $01), (entityy(collider, $01) + 1.3), entityz(collider, $01), $01)
                    showentity(collider)
                    hideentity(at\Field4[$05])
                    hideentity(at\Field4[$08])
                    killtimer = 0.0
                    killanim = $00
                    For local1 = Each events
                        If (local1\Field0 = "room009") Then
                            local1\Field2 = 0.0
                            local1\Field4 = 0.0
                        EndIf
                    Next
                Case "noclip","fly"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local7
                        Case "on","1","true"
                            chs\Field1 = $01
                            playable = $01
                        Case "off","0","false"
                            chs\Field1 = $00
                            rotateentity(collider, 0.0, entityyaw(collider, $00), 0.0, $00)
                        Default
                            chs\Field1 = (chs\Field1 = $00)
                            If (chs\Field1 = $00) Then
                                rotateentity(collider, 0.0, entityyaw(collider, $00), 0.0, $00)
                            Else
                                playable = $01
                            EndIf
                    End Select
                    If (chs\Field1 <> 0) Then
                        createconsolemsg("NOCLIP ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        createconsolemsg("NOCLIP OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    EndIf
                    dropspeed = 0.0
                Case "showfps"
                    showfps = (showfps = $00)
                    createconsolemsg(("ShowFPS: " + (Str showfps)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "096state"
                    For local30 = Each npcs
                        If (local30\Field5 = $06) Then
                            createconsolemsg("SCP-096", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg(((((("Position: " + (Str entityx(local30\Field0, $00))) + ", ") + (Str entityy(local30\Field0, $00))) + ", ") + (Str entityz(local30\Field0, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg(("Idle: " + (Str local30\Field24)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            createconsolemsg(("State: " + (Str local30\Field9)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                            Exit
                        EndIf
                    Next
                    createconsolemsg("SCP-096 has not spawned.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "debughud"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local7
                        Case "on","1","true"
                            debughud = $01
                        Case "off","0","false"
                            debughud = $00
                        Default
                            debughud = (debughud = $00)
                    End Select
                    If (debughud <> 0) Then
                        createconsolemsg("Debug Mode On", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        createconsolemsg("Debug Mode Off", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    EndIf
                Case "stopsound","stfu"
                    For local36 = Each sound
                        For local9 = $00 To $1F Step $01
                            If (local36\Field2[local9] <> $00) Then
                                stopchannel(local36\Field2[local9])
                            EndIf
                        Next
                    Next
                    For local1 = Each events
                        If (local1\Field0 = "room173") Then
                            If (local1\Field1\Field22[$00] <> Null) Then
                                removenpc(local1\Field1\Field22[$00])
                            EndIf
                            If (local1\Field1\Field22[$01] <> Null) Then
                                removenpc(local1\Field1\Field22[$01])
                            EndIf
                            If (local1\Field1\Field22[$02] <> Null) Then
                                removenpc(local1\Field1\Field22[$02])
                            EndIf
                            freeentity(local1\Field1\Field19[$00])
                            local1\Field1\Field19[$00] = $00
                            freeentity(local1\Field1\Field19[$01])
                            local1\Field1\Field19[$01] = $00
                            positionentity(curr173\Field4, 0.0, 0.0, 0.0, $00)
                            resetentity(curr173\Field4)
                            showentity(curr173\Field0)
                            removeevent(local1)
                            Exit
                        EndIf
                    Next
                    createconsolemsg("Stopped all sounds.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "camerafog"
                    local37 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    camerafognear = (Float left(local37, (len(local37) - instr(local37, " ", $01))))
                    camerafogfar = (Float right(local37, (len(local37) - instr(local37, " ", $01))))
                    createconsolemsg(((("Near set to: " + (Str camerafognear)) + ", far set to: ") + (Str camerafogfar)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "gamma"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    screengamma = (Float (Int local7))
                    createconsolemsg(("Gamma set to " + (Str screengamma)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "spawn"
                    local37 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    local7 = piece(local37, $01, " ")
                    local38 = piece(local37, $02, " ")
                    If (local7 <> local38) Then
                        console_spawnnpc(local7, local38)
                    Else
                        console_spawnnpc(local7, "")
                    EndIf
                Case "infinitestamina","infstam","is"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local7
                        Case "on","1","true"
                            chs\Field4 = $01
                        Case "off","0","false"
                            chs\Field4 = $00
                        Default
                            chs\Field4 = (chs\Field4 = $00)
                    End Select
                    If (chs\Field4 <> 0) Then
                        createconsolemsg("INFINITE STAMINA ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        createconsolemsg("INFINITE STAMINA OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    EndIf
                Case "asd2"
                    chs\Field0 = $01
                    chs\Field4 = $01
                    curr173\Field24 = 3.0
                    curr106\Field24 = 1.0
                    curr106\Field9 = 200000.0
                    contained106 = $01
                Case "disablenuke"
                    For local40 = Each events
                        If (local40\Field0 = "room2nuke") Then
                            local40\Field2 = 0.0
                            updatelever(local40\Field1\Field19[$01], $00)
                            updatelever(local40\Field1\Field19[$03], $00)
                            rotateentity(local40\Field1\Field19[$01], 0.0, entityyaw(local40\Field1\Field19[$01], $00), 30.0, $00)
                            rotateentity(local40\Field1\Field19[$03], 0.0, entityyaw(local40\Field1\Field19[$03], $00), 30.0, $00)
                            Exit
                        EndIf
                    Next
                Case "unlockexits"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local7
                        Case "a"
                            For local1 = Each events
                                If (local1\Field0 = "gateaentrance") Then
                                    local1\Field4 = 1.0
                                    local1\Field1\Field21[$01]\Field5 = $01
                                    Exit
                                EndIf
                            Next
                            createconsolemsg("Gate A is now unlocked.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Case "b"
                            For local1 = Each events
                                If (local1\Field0 = "gateb") Then
                                    local1\Field4 = 1.0
                                    local1\Field1\Field21[$04]\Field5 = $01
                                    Exit
                                EndIf
                            Next
                            createconsolemsg("Gate B is now unlocked.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                        Default
                            For local1 = Each events
                                If (local1\Field0 = "gateaentrance") Then
                                    local1\Field4 = 1.0
                                    local1\Field1\Field21[$01]\Field5 = $01
                                ElseIf (local1\Field0 = "gateb") Then
                                    local1\Field4 = 1.0
                                    local1\Field1\Field21[$04]\Field5 = $01
                                EndIf
                            Next
                            createconsolemsg("Gate A and B are now unlocked.", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    End Select
                    remotedooron = $01
                Case "kill","suicide"
                    killtimer = -1.0
                    Select rand($04, $01)
                        Case $01
                            deathmsg = "[DATA REDACTED]"
                        Case $02
                            deathmsg = "Subject D-9341 found dead in Sector [DATA REDACTED]. "
                            deathmsg = (deathmsg + "The subject appears to have attained no physical damage, and there is no visible indication as to what killed him. ")
                            deathmsg = (deathmsg + "Body was sent for autopsy.")
                        Case $03
                            deathmsg = "EXCP_ACCESS_VIOLATION"
                        Case $04
                            deathmsg = "Subject D-9341 found dead in Sector [DATA REDACTED]. "
                            deathmsg = (((((deathmsg + "The subject appears to have scribbled the letters ") + chr($22)) + "kys") + chr($22)) + " in his own blood beside him. ")
                            deathmsg = (deathmsg + "No other signs of physical trauma or struggle can be observed. Body was sent for autopsy.")
                    End Select
                Case "playmusic"
                    If (instr(consoleinput, " ", $01) <> $00) Then
                        local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Else
                        local7 = ""
                    EndIf
                    If (local7 <> "") Then
                        playcustommusic = $01
                        If (custommusic <> $00) Then
                            freesound_strict(custommusic)
                            custommusic = $00
                        EndIf
                        If (musicchn <> $00) Then
                            stopchannel(musicchn)
                        EndIf
                        custommusic = loadsound_strict(("SFX\Music\Custom\" + local7))
                        If (custommusic = $00) Then
                            playcustommusic = $00
                        EndIf
                    Else
                        playcustommusic = $00
                        If (custommusic <> $00) Then
                            freesound_strict(custommusic)
                            custommusic = $00
                        EndIf
                        If (musicchn <> $00) Then
                            stopchannel(musicchn)
                        EndIf
                    EndIf
                Case "tp"
                    For local30 = Each npcs
                        If (local30\Field5 = $14) Then
                            If (local30\Field47 = Null) Then
                                positionentity(collider, entityx(local30\Field4, $00), (entityy(local30\Field4, $00) + 5.0), entityz(local30\Field4, $00), $00)
                                resetentity(collider)
                                Exit
                            EndIf
                        ElseIf (local30\Field5 = $1C) Then
                            If (local30\Field77 = Null) Then
                                positionentity(collider, entityx(local30\Field4, $00), (entityy(local30\Field4, $00) + 5.0), entityz(local30\Field4, $00), $00)
                                resetentity(collider)
                                Exit
                            EndIf
                        EndIf
                    Next
                Case "tele"
                    local37 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    local7 = piece(local37, $01, " ")
                    local38 = piece(local37, $02, " ")
                    local43 = piece(local37, $03, " ")
                    positionentity(collider, (Float local7), (Float local38), (Float local43), $00)
                    positionentity(camera, (Float local7), (Float local38), (Float local43), $00)
                    resetentity(collider)
                    resetentity(camera)
                    createconsolemsg(((((("Teleported to coordinates (X|Y|Z): " + (Str entityx(collider, $00))) + "|") + (Str entityy(collider, $00))) + "|") + (Str entityz(collider, $00))), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "notarget","nt"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local7
                        Case "on","1","true"
                            chs\Field2 = $01
                        Case "off","0","false"
                            chs\Field2 = $00
                        Default
                            chs\Field2 = (chs\Field2 = $00)
                    End Select
                    If (chs\Field2 = $00) Then
                        createconsolemsg("NOTARGET OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        createconsolemsg("NOTARGET ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    EndIf
                Case "spawnradio"
                    local12 = createitem("Radio Transceiver", "fineradio", entityx(collider, $00), entityy(camera, $01), entityz(collider, $00), $00, $00, $00, 1.0, $00)
                    entitytype(local12\Field1, $03, $00)
                    local12\Field13 = 101.0
                Case "spawnnvg"
                    local12 = createitem("Night Vision Goggles", "nvgoggles", entityx(collider, $00), entityy(camera, $01), entityz(collider, $00), $00, $00, $00, 1.0, $00)
                    entitytype(local12\Field1, $03, $00)
                    local12\Field13 = 1000.0
                Case "spawnpumpkin","pumpkin"
                    createconsolemsg("What pumpkin?", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "spawnnav"
                    local12 = createitem("S-NAV Navigator Ultimate", "nav", entityx(collider, $00), entityy(camera, $01), entityz(collider, $00), $00, $00, $00, 1.0, $00)
                    entitytype(local12\Field1, $03, $00)
                    local12\Field13 = 101.0
                Case "teleport173"
                    positionentity(curr173\Field4, entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00), $00)
                    resetentity(curr173\Field4)
                Case "seteventstate"
                    local37 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    local7 = piece(local37, $01, " ")
                    local38 = piece(local37, $02, " ")
                    local43 = piece(local37, $03, " ")
                    local45 = piece(local37, $04, " ")
                    local46 = $00
                    If (((((local7 = "") Or (local38 = "")) Or (local43 = "")) Or (local45 = "")) <> 0) Then
                        createconsolemsg("Too few parameters. This command requires 4.", $FF, $96, $00, $00)
                    Else
                        For local1 = Each events
                            If (local1\Field1 = playerroom) Then
                                If (lower(local7) <> "keep") Then
                                    local1\Field2 = (Float local7)
                                EndIf
                                If (lower(local38) <> "keep") Then
                                    local1\Field3 = (Float local38)
                                EndIf
                                If (lower(local43) <> "keep") Then
                                    local1\Field4 = (Float local43)
                                EndIf
                                If (lower(local45) <> "keep") Then
                                    local1\Field5 = (Float local45)
                                EndIf
                                createconsolemsg(((((((("Changed event states from current player room to: " + (Str local1\Field2)) + "|") + (Str local1\Field3)) + "|") + (Str local1\Field4)) + "|") + (Str local1\Field5)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                                local46 = $01
                                Exit
                            EndIf
                        Next
                        If (local46 = $00) Then
                            createconsolemsg("The current room doesn't has any event applied.", $FF, $96, $00, $00)
                        EndIf
                    EndIf
                Case "spawnparticles"
                    If (instr(consoleinput, " ", $01) <> $00) Then
                        local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Else
                        local7 = ""
                    EndIf
                    If ((((Int local7) > $FFFFFFFF) And ((Int local7) <= $01)) <> 0) Then
                        setemitter(collider, particleeffect[(Int local7)], $00)
                        createconsolemsg((("Spawned particle emitter with ID " + (Str (Int local7))) + " at player's position."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        createconsolemsg((("Particle emitter with ID " + (Str (Int local7))) + " not found."), $FF, $96, $00, $00)
                    EndIf
                Case "giveachievement"
                    If (instr(consoleinput, " ", $01) <> $00) Then
                        local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Else
                        local7 = ""
                    EndIf
                    If ((((Int local7) >= $00) And ((Int local7) < $3B)) <> 0) Then
                        achievements((Int local7)) = $01
                        createconsolemsg((("Achievemt " + achievementstrings((Int local7))) + " unlocked."), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        createconsolemsg((("Achievement with ID " + (Str (Int local7))) + " doesn't exist."), $FF, $96, $00, $00)
                    EndIf
                Case "427state"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    i_427\Field1 = ((Float local7) * 70.0)
                Case "teleport106"
                    curr106\Field9 = 0.0
                    curr106\Field24 = 0.0
                Case "setblinkeffect"
                    local37 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    blinkeffect = (Float left(local37, (len(local37) - instr(local37, " ", $01))))
                    blinkeffecttimer = (Float right(local37, (len(local37) - instr(local37, " ", $01))))
                    createconsolemsg(((("Set BlinkEffect to: " + (Str blinkeffect)) + "and BlinkEffect timer: ") + (Str blinkeffecttimer)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "jorge"
                    createconsolemsg(((((((((((((((((((((((((((((chr($4A) + chr($4F)) + chr($52)) + chr($47)) + chr($45)) + chr($20)) + chr($48)) + chr($41)) + chr($53)) + chr($20)) + chr($42)) + chr($45)) + chr($45)) + chr($4E)) + chr($20)) + chr($45)) + chr($58)) + chr($50)) + chr($45)) + chr($43)) + chr($54)) + chr($49)) + chr($4E)) + chr($47)) + chr($20)) + chr($59)) + chr($4F)) + chr($55)) + chr($2E)), $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                Case "newyear"
                    at\Field1[$01] = (at\Field1[$01] = $00)
                    If (at\Field1[$01] <> 0) Then
                        local31 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\scp_173_ny.pt"), $01)
                        entitytexture(curr173\Field0, local31, $00, $00)
                        freetexture(local31)
                        createconsolemsg("173 COOKIE ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        local32 = loadtexture_strict(scpmodding_processfilepath("GFX\npcs\scp_173.png"), $01)
                        entitytexture(curr173\Field0, local32, $00, $00)
                        freetexture(local32)
                        createconsolemsg("173 COOKIE OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    EndIf
                Case "cheats"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local7
                        Case "on","1","true"
                            chs\Field3 = $01
                        Case "off","0","false"
                            chs\Field3 = $00
                        Default
                            chs\Field3 = (chs\Field3 = $00)
                    End Select
                    If (chs\Field3 = $01) Then
                        chs\Field0 = $01
                        chs\Field2 = $01
                        chs\Field1 = $01
                        chs\Field4 = $01
                        chs\Field5 = $01
                        createconsolemsg("CHEATS ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        chs\Field0 = $00
                        chs\Field2 = $00
                        chs\Field1 = $00
                        chs\Field4 = $00
                        chs\Field5 = $00
                        createconsolemsg("CHEATS OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    EndIf
                Case "fov"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    fov = (Float local7)
                Case "reset650"
                    For local30 = Each npcs
                        If (local30\Field5 = $1A) Then
                            removenpc(local30)
                            createevent("room650", "room650", $00, 0.0)
                            Exit
                        EndIf
                    Next
                Case "reset372"
                    For local30 = Each npcs
                        If (local30\Field5 = $09) Then
                            removenpc(local30)
                            createevent("room372", "room372", $00, 0.0)
                            Exit
                        EndIf
                    Next
                Case "crystal"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    i_409\Field0 = (Float local7)
                Case "reset1033ru"
                    i_1033ru\Field0 = $C8
                    i_1033ru\Field1 = $00
                Case "unlockachievements"
                    local48 = $00
                    For local9 = $00 To $3A Step $01
                        local48 = (local48 + achievements(local9))
                    Next
                    If (local48 <= $3A) Then
                        For local9 = $00 To $3A Step $01
                            achievements(local9) = $01
                        Next
                        createconsolemsg("All achievements unlocked!", $FF, $FF, $FF, $00)
                    Else
                        createconsolemsg("You are already unlocked all achievements.", $FF, $00, $00, $00)
                    EndIf
                Case "disable049"
                    For local30 = Each npcs
                        If (local30\Field5 = $03) Then
                            local30\Field9 = 0.0
                            hideentity(local30\Field4)
                            hideentity(local30\Field0)
                        EndIf
                    Next
                Case "enable049"
                    For local30 = Each npcs
                        If (local30\Field5 = $03) Then
                            local30\Field9 = 1.0
                            showentity(local30\Field4)
                            showentity(local30\Field0)
                        EndIf
                    Next
                Case "money","rich"
                    For local9 = $01 To $14 Step $01
                        If (rand($02, $01) = $01) Then
                            local12 = createitem("Quarter", "25ct", ((cos((18.0 * (Float local9))) * rnd(0.3, 0.5)) + entityx(collider, $01)), entityy(camera, $01), ((sin((18.0 * (Float local9))) * rnd(0.3, 0.5)) + entityz(collider, $01)), $00, $00, $00, 1.0, $00)
                        Else
                            local12 = createitem("Coin", "coin", ((cos((18.0 * (Float local9))) * rnd(0.3, 0.5)) + entityx(collider, $01)), entityy(camera, $01), ((sin((18.0 * (Float local9))) * rnd(0.3, 0.5)) + entityz(collider, $01)), $00, $00, $00, 1.0, $00)
                        EndIf
                        entitytype(local12\Field1, $03, $00)
                    Next
                Case "disablecontrol"
                    remotedooron = $00
                    createconsolemsg("Remote door control disabled.", $FF, $FF, $FF, $00)
                Case "enablecontrol"
                    remotedooron = $01
                    createconsolemsg("Remote door control enabled.", $FF, $FF, $FF, $00)
                Case "unlockcheckpoints"
                    For local40 = Each events
                        If (local40\Field0 = "room2sl") Then
                            local40\Field4 = 0.0
                            updatelever(local40\Field1\Field20[$00], $00)
                            rotateentity(local40\Field1\Field20[$00], 0.0, entityyaw(local40\Field1\Field20[$00], $00), 0.0, $00)
                            turncheckpointmonitorsoff($00)
                        EndIf
                    Next
                    For local40 = Each events
                        If (local40\Field0 = "room008") Then
                            local40\Field2 = 2.0
                            updatelever(local40\Field1\Field20[$00], $00)
                            rotateentity(local40\Field1\Field20[$00], 0.0, entityyaw(local40\Field1\Field20[$00], $00), 30.0, $00)
                            turncheckpointmonitorsoff($01)
                            Exit
                        EndIf
                    Next
                    createconsolemsg("Checkpoints unlocked.", $FF, $FF, $FF, $00)
                Case "disable966"
                    For local30 = Each npcs
                        If (local30\Field5 = $0D) Then
                            local30\Field9 = -1.0
                            hideentity(local30\Field4)
                            hideentity(local30\Field0)
                        EndIf
                    Next
                Case "enable966"
                    For local30 = Each npcs
                        If (local30\Field5 = $0D) Then
                            local30\Field9 = 0.0
                            showentity(local30\Field4)
                            If (local49 > $00) Then
                                showentity(local30\Field0)
                            EndIf
                        EndIf
                    Next
                Case "noblinking","nb"
                    local7 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local7
                        Case "on","1","true"
                            chs\Field5 = $01
                        Case "off","0","false"
                            chs\Field5 = $00
                        Default
                            chs\Field5 = (chs\Field5 = $00)
                    End Select
                    If (chs\Field5 <> 0) Then
                        createconsolemsg("NO BLINKING MODE ON", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    Else
                        createconsolemsg("NO BLINKING MODE OFF", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
                    EndIf
                Default
                    createconsolemsg("Command not found.", $FF, $00, $00, $00)
            End Select
            consoleinput = ""
        EndIf
        local51 = (Int (((Float (local4 + local6)) - (25.0 * menuscale)) - consolescroll))
        local52 = $00
        For local2 = Each consolemsg
            local52 = (local52 + $01)
            If (local52 > $3E8) Then
                Delete local2
            Else
                If (((local51 >= local4) And ((Float local51) < ((Float (local4 + local6)) - (20.0 * menuscale)))) <> 0) Then
                    If (local2 = consolereissue) Then
                        color((local2\Field2 Sar $02), (local2\Field3 Sar $02), (local2\Field4 Sar $02))
                        rect(local3, (Int ((Float local51) - (2.0 * menuscale))), (Int ((Float local5) - (30.0 * menuscale))), (Int (24.0 * menuscale)), $01)
                    EndIf
                    color(local2\Field2, local2\Field3, local2\Field4)
                    If (local2\Field1 <> 0) Then
                        aatext((Int ((20.0 * menuscale) + (Float local3))), local51, ("> " + local2\Field0), $00, $00, 1.0)
                    Else
                        aatext((Int ((20.0 * menuscale) + (Float local3))), local51, local2\Field0, $00, $00, 1.0)
                    EndIf
                EndIf
                local51 = (Int ((Float local51) - (15.0 * menuscale)))
            EndIf
        Next
        color($FF, $FF, $FF)
        If (fullscreen <> 0) Then
            drawimage(cursorimg, scaledmousex(), scaledmousey(), $00)
        EndIf
    EndIf
    aasetfont(local0\Field0[$00])
    Return $00
End Function
