Function turncheckpointmonitorsoff%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5.objects
    Local local6$
    local5 = (First objects)
    If (arg0 = $00) Then
        local4 = local5\Field2[$01]
        updatecheckpoint1 = $00
        monitortimer = 0.0
    Else
        local4 = local5\Field2[$02]
        updatecheckpoint2 = $00
        monitortimer2 = 0.0
    EndIf
    For local0 = $02 To countsurfaces(local4) Step $01
        local1 = getsurface(local4, local0)
        local2 = getsurfacebrush(local1)
        If (local2 <> $00) Then
            local3 = getbrushtexture(local2, $00)
            If (local3 <> $00) Then
                local6 = strippath(texturename(local3))
                If (lower(local6) <> "monitoroverlay.png") Then
                    brushtexture(local2, at\Field5[$14], $00, $00)
                    paintsurface(local1, local2)
                EndIf
                If (local6 <> "") Then
                    freetexture(local3)
                EndIf
            EndIf
            freebrush(local2)
        EndIf
    Next
    Return $00
End Function