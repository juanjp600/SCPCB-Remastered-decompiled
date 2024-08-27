Function kill%(arg0%, arg1%)
    If (usedconsole <> $01) Then
    EndIf
    If (chs\Field0 <> 0) Then
        Return $00
    EndIf
    If (breathchn <> $00) Then
        If (channelplaying(breathchn) <> 0) Then
            stopchannel(breathchn)
        EndIf
    EndIf
    If (0.0 <= killtimer) Then
        killanim = rand($00, $01)
        playsound_strict(damagesfx($00))
        If (selecteddifficulty\Field2 <> 0) Then
            deletefile((((currentdir() + "Saves\") + currsave) + "\save.txt"))
            deletedir(("Saves\" + currsave))
            loadsavegames()
        EndIf
        killtimer = min(-1.0, killtimer)
        showentity(head)
        positionentity(head, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $01)
        resetentity(head)
        rotateentity(head, 0.0, entityyaw(camera, $00), 0.0, $00)
        If (arg0 = $01) Then
            showentity(at\Field4[$05])
        EndIf
        If (arg1 = $01) Then
            showentity(at\Field4[$08])
        EndIf
    EndIf
    Return $00
End Function
